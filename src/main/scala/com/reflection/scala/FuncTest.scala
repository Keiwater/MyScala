package com.reflection.scala

object FuncTest {
  def main(args: Array[String]): Unit = {

//    val r = ObjectFunc.func2(10)
//    println("objectFunc: "+r)
//
//
//    var clss = new ClassFunc
//    val clss_res = clss.func1(20)
//    println("classFunc: "+clss_res)



    // 反射的应用：
    // 反射class类
    // def functor[R]( className: String, methodName: String ): Unit ={}  这里的 [R] 表示：通过类名称，与方法名称反射过后，对应的方法需要传入的输入参数数据类型
    val f1 = FuncReflectUtils.functor[String]("com.reflection.scala.ClassFunc","func1")
    val f2 = FuncReflectUtils._functor[String]("com.reflection.scala.ObjectFunc","func2")

    val res = f2(Seq(10))
    print(res)


  }
}
