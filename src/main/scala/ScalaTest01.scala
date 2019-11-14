import scala.collection.mutable.ArrayBuffer

object ScalaTest01 {

  def main(args: Array[String]): Unit = {

    val printIN =readLine("Your name: ")

    println("输入的内容是：  "+ printIN )

    val age = readInt()

    printf("Hello 当前介绍的是： %s  ! and 明年的时候，主人公就： %d 岁了。\n " , printIN,age+1)

    for (c <- "hello"; i <- 0 to 1) yield (c + i).toChar
//      println (yield (c + i).toChar)
//    for (i <- 0 to 1 ; c <- "hello") println(yield (c + i).toChar)

    def sum(args : Int*) = {
      var result = 0
      for (i <- args) {
        result += i
      }
      result
    }

    val s = sum(1,2,3,4,5)
    print(s)


    val b = ArrayBuffer[Int]()

    b += 1
    b ++ Array(1,8,18,28)
    println(b.toArray)
//    b.toArray()



  }

}