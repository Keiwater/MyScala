package com.rpc.akka.scala

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

//定义一个（一个类型的）actor，类型定义的名称为：Maser
class Master extends Actor {

  override def receive: Receive = {

    case "Register" =>{
      println("A Register msg from Worker")
      sender!"Response"
    }
    case "HeartBeat" => {}
    case "CheckTimeOut" => {
      println("internal msg check")
    }
  }
}
//在他的伴生对象里面定义main入口方法：
object Master {
  def main(args: Array[String]): Unit = {

    val host = "172.20.9.60"
    val port = 9999.toInt
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
       """.stripMargin

    val config = ConfigFactory.parseString(configStr)
    // 注意这里的   ActorSystem 使用的是 工厂模式
    println(config)
    // 创建ActorSystem(单例)，对象名字是：MasterActorSystem
    val actorSystem = ActorSystem("MasterActorSystem",config)
    // 通过ActorSystem 新建 一个类型为 Props[com.rpc.akka.scala.Master] 类型的actor，实例对象定义为：Actor (这里用到的是 ActorRef 代理模式)，多态
    val masterActor: ActorRef = actorSystem.actorOf(Props[Master],"MasterA")

    masterActor ! "CheckTimeOut"

  }
}
