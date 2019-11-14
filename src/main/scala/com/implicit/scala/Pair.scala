package com.`implicit`.scala

// 上下界 ： <:,>:； 与 视图绑定 %

/***
  *
  * scala 的泛型 []
  *
  * [T <: Comparable ]    上界        upper bound
  * [T :> Comparable ]    下界        lower bound
  * [T : Comparable ]     上下文界定， context bound
  * [T % Comparable ]     视图界定，   view bound
  * [+T]      协变
  * [-T]      逆变
  * @param ev$1
  * @tparam T
  */


class Pair[T <% Comparable[T]] {
//class Pair[T <: Comparable[T]] {

  def bigger(first:T, second:T ): T ={

    if(first.compareTo(second) > 0) first else second
  }
}

object Pair{
  def main(args: Array[String]): Unit = {

    val p: Pair[Boy] = new Pair[Boy]
    val boy: Boy = p.bigger(new Boy("laozhao",9999,18),new Boy("xiaoLi",10000,10))
    println(boy.name)


    val testInt: Pair[Int] = new Pair[Int]
    val res = testInt.bigger(10,100)
    println(res)

  }
}
