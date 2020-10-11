package com.yechangqing.demo.java.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

  private final int port;

  public EchoServer(int port) {
    this.port = port;
  }

  public void start() throws InterruptedException {
    final ChannelInboundHandlerAdapter echoServerHandler = new ChannelInboundHandlerAdapter() {
      @Override
      public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
      }

      @Override
      public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
      }

      @Override
      public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
      }
    };

    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    ServerBootstrap serverBootstrap = new ServerBootstrap();
    serverBootstrap.group(eventLoopGroup)
      .channel(NioServerSocketChannel.class)
      .localAddress(port)
      .childHandler(new ChannelInitializer() {
        @Override
        protected void initChannel(Channel ch) throws Exception {
          ch.pipeline().addLast(echoServerHandler);
        }
      });
    var future =  serverBootstrap.bind().sync();
    future.channel().closeFuture().sync();
  }


  public static void main(String[] args) throws InterruptedException {
    new EchoServer(8888).start();
  }
}
