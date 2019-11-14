package com.oop.scala

class Person(val id : Long, val name: String ="tom", var age:Int){

  var gender = "male"

  def this(id:Long,name:String,age:Int,gender:String){
    this(id,name,age)
    this.gender = gender
  }
}

object Person {
  def main(args: Array[String]): Unit = {



  }
}
