package com.yechangqing.demo.java.netty.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class IMServer {

  public final int port;

  public IMServer(int port) {
    this.port = port;
  }

  public void start() throws InterruptedException {
    NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
    ServerBootstrap serverBootstrap = new ServerBootstrap();
    serverBootstrap.group(nioEventLoopGroup).channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast("decoder", new StringDecoder());
            ch.pipeline().addLast("encoder", new StringEncoder());
            ch.pipeline().addLast(new ServerStringChannelHandler());
          }
        });
    serverBootstrap.bind(port).sync();
  }

  public static void main(String[] args) throws InterruptedException {
    new IMServer(8888).start();
  }
}
