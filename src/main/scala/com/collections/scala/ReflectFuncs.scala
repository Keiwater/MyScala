package com.collections.scala

import scala.reflect._
object FuncReflectUtils {

  // 反射 class
  def functor[R](className:String, methodName:String): Unit ={
    val m = universe.runtimeMirror(getClass.getClassLoader)
    val clazz = Class.forName(className)
    val symbol = m.classSymbol(clazz)

  }


  //
  def _functor[R](className:String,methodName:String): Unit ={

  }

}
