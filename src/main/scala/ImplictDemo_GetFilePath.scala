import java.io.File

import scala.io.Source

class RichFile(val file:File){
  def read = Source.fromFile(file.getPath()).mkString
}

object Context{
  implicit def file2RichFile(f:File)= new RichFile(f)
}

object ImplictDemo_GetFilePath {
  def main(args: Array[String]) {
    import Context.file2RichFile
    println(new File("f:\\create.sql").read)
  }
}
