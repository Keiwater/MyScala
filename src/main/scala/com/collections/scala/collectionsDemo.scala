package com.collections.scala

object collectionsDemo {
  def main(args: Array[String]): Unit = {

    println("Say Hello")

    val lst = scala.collection.mutable.LinkedList(1,-2,7,-9)
    //    cur 指向，lst对象的 另外一个引用
    var cur = lst
    while (cur != Nil) {
      if(cur.elem < 0) cur.elem = 0
      cur = cur.next
    }
    println(lst)
  }
}
