package com.rpc.spark.scala

// master actor 自检 信息，单例对象
case object CheckTimeOutWork
case object RegisteredResponse
case object SendHeartbeats


// 定义用户注册信息样例类
case class RegisterWorker( val workerId :String, val memory:Int, val cores:Int ) extends Serializable
// 定义用户心跳信息样例类
case class HeartBeat( workerId:String ) extends Serializable

