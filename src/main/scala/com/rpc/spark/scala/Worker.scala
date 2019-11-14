package com.rpc.spark.scala

import java.util.UUID

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}


class Worker(val host: String, val port: Int, val workermemory: Int, val workercores: Int) extends Actor {

  val WORKER_ID = UUID.randomUUID().toString
  val HEARTBEAT_INTERVAL = 15000

  override def preStart(): Unit = {
    // 动态 生成 MasterActor 代理
    val master: ActorSelection = context.actorSelection(s"akka.tcp://${Master.MASTER_ACTOR_SYSTEM_NAME}@$host:$port/user/${Master.MASTER_ACTOR_NAME}")
    master !RegisterWorker(WORKER_ID,workermemory,workercores)

  }

  override def receive: Receive = {


    //
    case RegisteredResponse => {

      println(" A Response msg from Master")
      // 当worker actor 拿到 注册成功的消息之后，应该给master 返回一个心跳信息：
      val master: ActorSelection = context.actorSelection(s"akka.tcp://${Master.MASTER_ACTOR_SYSTEM_NAME}@$host:$port/user/${Master.MASTER_ACTOR_NAME}")
      master ! RegisterWorker(WORKER_ID,workermemory,workercores)

      // 启动一个定时器： 定期给Master 发送心跳信息：
//      ( 0 , HEARTBEAT_INTERVAL  , self , SendHeartbeat)
//      import context.dis
//      context.system.scheduler.schedule(0,HEARTBEAT_INTERVAL,self, SendHeartbeats)

    }
//
//
//    case SendHeartbeat => {
//      // 在 该 case 中可以进行一些逻辑判断
//      master ! HeartBeat(WORKER_ID)
//    }
  }
}

object Worker {

  val WORKER_ACTOR_SYSTEM_NAME = "WorkerActorSystem"
  val WORKER_ACTOR_NAME = "WorkerActor"

  def main(args: Array[String]): Unit = {

    val workerHost = args(0)
    val workerPort = args(1).toInt
    val masterHost = args(2)
    val masterPort = args(3).toInt

    val workermemory = args(4).toInt
    val workercores = args(5).toInt

    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$workerHost"
         |akka.remote.netty.tcp.port = "$workerPort"
       """.stripMargin

    val config: Config = ConfigFactory.parseString(configStr)
    val workeractorsystemname: ActorSystem = ActorSystem(WORKER_ACTOR_SYSTEM_NAME, config)
    // 初始化worker actor
    val workeractorname: ActorRef = workeractorsystemname.actorOf(Props(new Worker(masterHost,masterPort,workermemory,workercores)),WORKER_ACTOR_NAME)

  }
}
