package com.reflection.scala

import scala.reflect.runtime._


object FuncReflectUtils {


  // 反射class类
  def functor[R]( className: String, methodName: String )={

    // 拿到一个反射器：初始化一个反射器对象
    val m = universe.runtimeMirror(getClass.getClassLoader())
    val clazz = Class.forName(className)
    val symbol = m.classSymbol(clazz)

    val method = symbol.typeSignature
      .members
      .filter( x => x.isMethod && x.name.toString==methodName )
      .head
      .asMethod

    // 使用类加载器，拿到的类标识和 方法标识，来执行对应的方法；
    val call = m.reflect(clazz.newInstance()).reflectMethod(method)

    (call.apply _) andThen(_.asInstanceOf[R])

  }



  // 反射object
  def _functor[R](className:String, methodName: String)={

    val m = universe.runtimeMirror(getClass.getClassLoader)
    val clazz = Class.forName(className)
    val symbol = m.moduleSymbol(clazz)

    val method = symbol.typeSignature
      .members
      .filter( x=> x.isMethod && x.name.toString == methodName)
      .head
      .asMethod

    val call = m.reflect(m.reflectModule(symbol).instance).reflectMethod(method)

    (call.apply _) andThen (_.asInstanceOf[R])

  }


}

