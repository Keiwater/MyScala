import Array._
object Test {

  def main(args: Array[String]) {
    println( "Returned Value : " + addInt(5,7) );

    var myList1 = Array(1.9, 2.9, 3.4, 3.5)
    var myList2 = Array(8.9, 7.9, 0.4, 1.5)

    var myList3 =  concat( myList1, myList2)

    println("length : "+ myList3.length)

    for ( x <- myList1 ) {
      println( " " + x )
    }
  }

  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b
    return sum
  }

}