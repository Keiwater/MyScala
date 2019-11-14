package com.rpc.akka.scala

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class MasterBk extends Actor{

  println("constructor invoked")

  override def preStart(): Unit = {
    println(" preStart invoked")
  }

  //用于接收消息
  override def receive: Receive = {
    case "connect" => {
      println("a client connected")
      sender ! "reply"
    }
    case "hello" => {
      println("hello")
    }
  }
}

object MasterBk {
  def main(args: Array[String]): Unit = {

    val host = args(0)
    val port = args(1).toInt
    //准备配置
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
       """.stripMargin
    val config = ConfigFactory.parseString(configStr)
    val masterSystem: ActorSystem = ActorSystem("MasterSystem", config)
    //ActorSystem老大，辅助创建和监控下面的Actor,他是单例的
    val actorSystem = masterSystem
    //创建Actor
    //方式一：val master = actorSystem.actorOf(Props[com.rpc.akka.scala.Master], "com.rpc.akka.scala.Master")
    val master = actorSystem.actorOf(Props(new MasterBk), "com.rpc.akka.scala.Master")
    master ! "hello"
//    actorSystem.awaitTermination()

  }
}
