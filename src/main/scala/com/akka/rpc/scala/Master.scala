package com.akka.rpc.scala

class Master extends Actor{

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

object Master {
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
    //ActorSystem老大，辅助创建和监控下面的Actor,他是单例的
    val actorSystem = ActorSystem("MasterSystem", config)
    //创建Actor
    //方式一：val master = actorSystem.actorOf(Props[Master], "Master")
    val master = actorSystem.actorOf(Props(new Master), "Master")
    master ! "hello"
    actorSystem.awaitTermination()

  }
}

