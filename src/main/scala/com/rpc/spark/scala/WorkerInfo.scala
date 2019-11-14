package com.rpc.spark.scala

class WorkerInfo(val workerid:String, val memory:Int, val cores:Int) {

  var lastHeartBeatTime: Long = System.currentTimeMillis()
}
