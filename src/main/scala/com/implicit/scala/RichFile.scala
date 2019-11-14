package com.`implicit`.scala

import java.io.File

import scala.io.Source

class RichFile(file:File) {

  def read(): String =Source.fromFile(file).mkString

}

object RichFile{

  def main(args: Array[String]): Unit = {

//    val content = new RichFile(new File("D:\\filenames.txt")).read()

    import MyPreDef.file2RichFile

    val content = new File("D:\\filenames.txt").read()

    println(content)

  }
}
