package com.`implicit`.scala

class Boy( val name:String,val faceValue:Int, val age:Int) extends Comparable[Boy] {

  override def compareTo(o: Boy): Int = {
    if(this.faceValue == o.faceValue){
      this.age - o.age
    }else{
      -(this.faceValue-o.faceValue)
    }
  }

  override def toString: String = s"name: $name, age: $age, faceValue: $faceValue"
}

object Boy{

  def main(args: Array[String]): Unit = {

    val boys: Array[Boy] = Array[Boy](new Boy("Xiaoming",9,10),new Boy("XiaoGong",10,3),new Boy("LaoYang",99,19))
    val sorted: Array[Boy] = boys.sorted
    println(sorted.toBuffer)
  }
}