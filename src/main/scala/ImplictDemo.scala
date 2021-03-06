object ImplictDemo {

  object Context{
    implicit val ccc:String = "implicit"
  }
  
  object Param{
    def print(content:String)(implicit prefix:String){
      println(prefix+":"+content)
    }
  }

  def main(args: Array[String]) {
    Param.print("jack")("hello")

    import Context._
    Param.print("jack")
  }

}

//程序运行结果为:
//hello:jack
//implicit:jack