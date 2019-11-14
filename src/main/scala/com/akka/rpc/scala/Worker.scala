package com.akka.rpc.scala

class Worker extends Actor{


  // 在 Actor 的构造方法之后，在 receive 方法执行之前，只执行一次
  override def preStart(): Unit = {

  }

  // 会在 Actor 的 生命周期中一直 存在，并运行着
  override def receive: Receive = {
    case "Response" =>{
      println("a response from Master")
    }
  }
}

object Worker{

  def main(args: Array[String]): Unit = {

    val host = "localhost"
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
       """.stripMargin

    val config = ConfigFactory.parseString(configStr)
    val actorSystem = ActorSystem("WorkerActorSystem",config)

    val workerA: ActorRef = actorSystem.actorOf(Props[Worker],"Worker-A")





  }

}
