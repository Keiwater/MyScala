package com.`implicit`.scala

import java.io.File

object MyPreDef {

  implicit def file2RichFile(file:File): RichFile = new RichFile(file)


  implicit def girlToOrderingGirl(girl:Girl) :Ordered[Girl] = new Ordered[Girl]{
    override def compare(that: Girl): Int = {

    }
  }

}
