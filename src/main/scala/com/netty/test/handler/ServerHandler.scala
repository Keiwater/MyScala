package com.netty.test.handler

import com.netty.test.message.RegisterMsg
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}

class ServerHandler extends ChannelInboundHandlerAdapter{


  /**
    * 有客户端建立连接后调用
    * @param ctx
    *
    */
  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    println("一个客户端连接上来了！！！")
  }

  /***
    * 接收客户端发来的消息，处理接收到客户端消息之后，服务端做出的相关动作
    * @param ctx
    * @param msg
    */

  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    println("收到客户端发来的消息了！！！")

//    val byteBuf = msg.asInstanceOf[ByteBuf]
//    val bytes = new Array[Byte](byteBuf.readableBytes())
//    byteBuf.readBytes(bytes)
//    val message: String = new String(bytes,"UTF-8")
//    println(message)
//
//    val back_msg = "Good Boy"
//    val resp = Unpooled.copiedBuffer(back_msg.getBytes("UTF-8"))
//    // 将数据发送到 客户端
//    ctx.write(resp)

    println(msg)

    val result = msg match {
      case RegisterMsg(msg) => {}
    }
    ctx.write(result)
  }

  /****
    * 将消息队列中的数据，写入到SocketChannel并发送到对方
    * @param ctx
    */
  override def channelReadComplete(ctx: ChannelHandlerContext): Unit = {
    println("channelReadComplete invoked ")
    ctx.flush()
  }


  /***
    *  发生异常时关闭ChannelHandlerContext
    * @param ctx
    * @param cause
    */
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {

    println("exceptionCaught invoked")
    ctx.close()
  }

}

object ServerHandler {

}
