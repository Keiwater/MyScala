package com.highlevel.scala

object Number {
  def main(args: Array[String]): Unit = {

    val Number(n) = "123456"
    println(n)

  }

  def unapply(arg: String): Option[Int] = {

    try {
      Some(Integer.parseInt(arg))
    } catch {
      case exception: Exception => None
    }
  }
}
