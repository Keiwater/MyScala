package com.netty.test.handler

import com.netty.test.message.RegisterMsg
import io.netty.buffer.ByteBuf
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}

class ClientHandler extends ChannelInboundHandlerAdapter{

  // 一旦跟服务端建立上连接，channelActive 将被调用
  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    println("已经跟服务端连接上了")

    // 客户端建立连接之后，给Server端返回一条消息
//    val content = "hello Server"
    // 将数据发送给服务端
//    ctx.writeAndFlush(Unpooled.copiedBuffer(content.getBytes("UTF-8")))

    ctx.writeAndFlush(RegisterMsg("hello Server"))
  }

  /***
    *
    * 客户端接收到 服务端的消息之后，客户端 做的相关动作
    *
    * @param ctx
    * @param msg
    */

  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    println("channelRead")
    val byteBuf: ByteBuf = msg.asInstanceOf[ByteBuf]
    val bytes = new Array[Byte](byteBuf.readableBytes())
    byteBuf.readBytes(bytes)
    val message = new String(bytes,"UTF-8")

    println(message)

  }

  override def channelReadComplete(ctx: ChannelHandlerContext): Unit = {
    println("channelReadComplete")
    ctx.flush()
  }

  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {

    println("exceptionCaught")
    ctx.close()
  }
}





