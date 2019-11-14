package com.akka.rpc.scala

import akka.actor.ActorSystem

object StudentSimulatorApp extends App {

  // Initialize the ActorSystem 大学 信息系统
  val actorSystem = ActorSystem("UniversityMessageSystem")

  // constrcut the Teacher Actor Ref
//  val teacherActorRef: ActorRef = actorSystem.actorOf(Props[TeacherActor])

  //send a message to the Teacher Actor
//  teacherActorRef!QuoteRequest

  //let's wait for a couple of seconds before we shut down the system
//  Thead.sleep(30000)

  //shut down the system
//  actorSystem.shutdown()




}
