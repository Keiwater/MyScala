package com.netty.test.client

import com.netty.test.handler.ClientHandler
import io.netty.bootstrap.Bootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.channel.{ChannelFuture, ChannelInitializer}
import io.netty.handler.codec.serialization.{ClassResolvers, ObjectDecoder, ObjectEncoder}


class NettyClient {

  def connect(host:String, port: Int): Unit ={

    // 创建客户端NIO 线程组
    val eventGroup: NioEventLoopGroup = new NioEventLoopGroup()
    // 创建 客户端辅助的启动类
    val bootstrap = new Bootstrap
    try {
      // 将NIO 线程组传入到 Bootstrap
      bootstrap.group(eventGroup)
        // 创建NioSocketChannel
        .channel(classOf[NioSocketChannel])
        // 绑定I/O 事件处理类
        .handler(new ChannelInitializer[SocketChannel] {
          override def initChannel(ch: SocketChannel): Unit = {

            ch.pipeline().addLast(
              new ObjectEncoder,
              new ObjectDecoder(ClassResolvers.cacheDisabled(getClass.getClassLoader)),
              new ClientHandler
            )
          }
        })

      // 发起异步连接操作
      val channelFuture: ChannelFuture = bootstrap.connect(host,port).sync()
      // 等待服务关闭
      channelFuture.channel().closeFuture().sync()
    }finally {
      // 优雅的退出
      eventGroup.shutdownGracefully()
    }
  }
}



object NettyClient{

  def main(args: Array[String]): Unit = {

    val host = args(0)
    val port = args(1).toInt
    val client = new NettyClient
    client.connect(host,port)
  }
}

