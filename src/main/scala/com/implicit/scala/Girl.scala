package com.`implicit`.scala

class Girl ( val name:String,val faceValue:Int, val age:Int) extends Ordered[Girl]{
  override def compare(o: Girl): Int = {
    if(this.faceValue == o.faceValue){
      this.age - o.age
    }else{
      -(this.faceValue-o.faceValue)
    }
  }
}

