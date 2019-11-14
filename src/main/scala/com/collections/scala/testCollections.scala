package com.collections.scala

object testCollections {

  def main(args: Array[String]): Unit = {

    val symbols = Array("<","-",">")
    val counts  = Array(2,10,2)

    val pairs = symbols.zip(counts)

    for( (s,n) <- pairs){
      Console.print( s * n)
    }

    println()
    print(symbols.zip(counts).toMap)

    val a = new Counter()
    print(a.increament())

  }

}

class Counter {

  private var value = 0

  //  执行的操作是 进行value + 1 ，但是方法本身并不返回值，即使存在返回值，也是 Unit类型的
  def increament() { value += 1 }

  def current() = value

}
