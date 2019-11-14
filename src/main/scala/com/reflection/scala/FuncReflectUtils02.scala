package com.reflection.scala
import scala.reflect.runtime.universe._
object FuncReflectUtils02 {
  def main(args: Array[String]): Unit = {

    val m = runtimeMirror(getClass.getClassLoader)


  }
}
