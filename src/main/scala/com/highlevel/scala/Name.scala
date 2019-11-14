package com.highlevel.scala

object Name {
  def main(args: Array[String]): Unit = {

    val author = "Cay Horstmann"

    val Name(first,last) = author

    println(first)
    println(last)

  }

  def unapply(arg: String) ={
    val pos = arg.indexOf(" ")

    if(pos == -1) None
    else Some((arg.substring(0, pos),arg.substring(pos+1)))

  }
}
