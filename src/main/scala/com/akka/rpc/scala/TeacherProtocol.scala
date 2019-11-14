package com.akka.rpc.scala

object TeacherProtocol {
  case class QuoteRequest()
  case class QuoteResponse(quoteString:String)
}
