package com.regex.scala

import scala.util.matching.Regex

object test {

  def main(args: Array[String]) {
    val pattern = "Scala".r
    val pattern01 = new Regex("(S|s)cala")
    val str = "Scala is scalable and cool Scala"

    println(pattern findFirstIn str)
    println((pattern findAllIn str).mkString(","))
    println((pattern01 findAllIn str).mkString(","))

    // 定义了一个 正则表达式对象
    val pattern02 = "([0-9]+) ([a-z]+)".r

    "99 bottles" match {

      case pattern02(nums, items)  => println(nums, items)
    }

  }

}
