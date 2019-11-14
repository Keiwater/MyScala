package com.rpc.spark.scala

import akka.actor.{Actor, ActorRef, ActorSystem, Cancellable, Props}
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class Master extends Actor{

  val CHECK_INTERVAL = 15000
  val id2Wokers = new mutable.HashMap[String,WorkerInfo]()
  val Workers = new mutable.HashSet[WorkerInfo]()


  override def preStart(): Unit = {

    // 首先进行自检
    //    context.system.scheduler.schedule(0 millis,CHECK_INTERVAL millis)
    val cancellable: Cancellable = context.system.scheduler.schedule(0 millis, CHECK_INTERVAL millis, self, CheckTimeOutWork)

  }



  override def receive: Receive = {


    // master 用来自检的消息， 处理心跳超时的 worker actor ，维护master中的worker列表信息
    case CheckTimeOutWork =>{
      println(" A internal msg check")

      println(" The size of WokerInfo is : " + id2Wokers.size)

      val current = System.currentTimeMillis()
      // 过滤出超时的worker
      val deadWorkers = Workers.filter( w => current - w.lastHeartBeatTime > CHECK_INTERVAL )

      deadWorkers.foreach( w=>{
        Workers.remove(w)
        id2Wokers.remove(w.workerid)

      })

    }


    // worker 发送给 master 的注册消息，master 接收到 注册消息，并处理 注册信息
    case RegisterWorker(workerId :String, memory:Int, cores:Int) => {

      val workerInfo = new WorkerInfo(workerId,memory,cores)
      id2Wokers.put(workerId,workerInfo)
      Workers += workerInfo
      sender() ! RegisteredResponse
    }


    // worker 发送给Master的心跳消息
    case HeartBeat(workerId) => {

      // 根据ID 到id2worker 这个map中直接查找对应的 workerInfo
      val workerInfo : WorkerInfo = id2Wokers(workerId)
      // 更新时间
      val current = System.currentTimeMillis()
      workerInfo.lastHeartBeatTime = current

    }
  }
}

object Master {

  val MASTER_ACTOR_SYSTEM_NAME = "MasterActorSystem"
  val MASTER_ACTOR_NAME = "MasterActor"

  def main(args: Array[String]): Unit = {

    val host = args(0)
    val port = args(1).toInt
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
       """.stripMargin

    val config: Config = ConfigFactory.parseString(configStr)
    val masteractorsystem: ActorSystem = ActorSystem(MASTER_ACTOR_SYSTEM_NAME,config)
    val masteractorname: ActorRef = masteractorsystem.actorOf(Props[Master],MASTER_ACTOR_NAME)

  }
}