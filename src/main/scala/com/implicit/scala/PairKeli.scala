package com.`implicit`.scala

/***
  * 使用 柯里化方式，(来实现隐式转化）的方式，实现 view bound
  *
  * @tparam T
  */

class PairKeli[T] {

  // p.bigger(1,10)(implicit f: Int => Interger )
  def bigger( first:T, second:T )(implicit f:T=> Comparable[T]): T ={
    if(first.compareTo(second) > 0) first else second

  }
}

object PairKeli{

  def main(args: Array[String]): Unit = {

    val test: PairKeli[Int] = new PairKeli[Int]
    val res: Int = test.bigger(10,100)

    println(res)
  }

}