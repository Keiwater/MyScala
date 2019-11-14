package com.rpc.akka.scala

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class Worker extends Actor{

  override def preStart(): Unit = {

    val masterA: ActorSelection = context.actorSelection("akka.tcp://MasterActorSystem@172.20.9.60:9999/user/MasterA")
    masterA!"Register"

  }
  override def receive: Receive = {

    case "Response" => {
      println("a Response msg from master")
    }
  }
}

object Worker {

  def main(args: Array[String]): Unit = {

    val host = "localhost"
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
       """.stripMargin
    val config = ConfigFactory.parseString(configStr)

    val workerActorSystem: ActorSystem = ActorSystem("WorkerActorSystem",config)
    val worker0: ActorRef = workerActorSystem.actorOf(Props[Worker],"Worker01")

  }
}
