package com.netty.test.server

import com.netty.test.handler.ServerHandler
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.{ChannelFuture, ChannelInitializer}
import io.netty.handler.codec.serialization.{ClassResolvers, ObjectDecoder, ObjectEncoder}

class NettyServer {

  def bind(host:String,port:Int): Unit ={
    //配置服务端线程池组
    //用于服务器接收用户端的链接
    val bossGroup: NioEventLoopGroup = new NioEventLoopGroup()
    //用户进行SockectChannel的网路读写
    val workerGroup: NioEventLoopGroup = new NioEventLoopGroup()

    try{
      // 是Netty 用户 启动NIO 服务器端的辅助启动类，降低服务端的开发复杂度
      val bootstrap = new ServerBootstrap()
      // 将两个NIO 线程组 作为阐述传入到ServerBootstrap
      bootstrap.group(bossGroup,workerGroup)
      // 创建NioServerSocketChannel
        .channel(classOf[NioServerSocketChannel])
      // 绑定I/O 事件处理类
        .childHandler(new ChannelInitializer[SocketChannel] {
        override def initChannel(ch: SocketChannel): Unit = {
          ch.pipeline().addLast(
            new ObjectEncoder,
            new ObjectDecoder(ClassResolvers.cacheDisabled(getClass.getClassLoader)),
            new ServerHandler
          )
        }
      })

      // 绑定端口，调用Sync 方法等待绑定操作完成
      val channelFuture: ChannelFuture = bootstrap.bind(host,port).sync()
      // 等待服务关闭
      channelFuture.channel().closeFuture().sync()
    } finally {

      // 优雅的退出，释放线程池资源
      bossGroup.shutdownGracefully()
      workerGroup.shutdownGracefully()
    }
  }
}

object NettyServer {

  def main(args: Array[String]): Unit = {

    val host = args(0)
    val port = args(1).toInt

    val server: NettyServer = new NettyServer
    server.bind(host,port)
  }
}
