package com.threads.scala

class ThreadExample() extends Thread{
  override def run(){
    for(i<- 0 to 5){
      println(i)
      Thread.sleep(500)
    }
  }
  def task(){
    for(i<- 0 to 5){
      println(i)
      Thread.sleep(200)
    }
  }
}

object Demo{
  def main(args:Array[String]){
    var t1 = new ThreadExample()
    t1.start()
    t1.task()
  }
}
