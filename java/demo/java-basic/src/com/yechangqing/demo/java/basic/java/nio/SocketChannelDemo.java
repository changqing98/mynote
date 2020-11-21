package com.yechangqing.demo.java.basic.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {

  public static void main(String[] args) throws IOException {
    SocketChannel sc = SocketChannel.open();
    boolean connect = sc.connect(new InetSocketAddress("localhost", 8899));
    ByteBuffer buf = ByteBuffer.allocate(1024);
    int bytesRead = sc.read(buf);
    System.out.println(new String(buf.array()));
  }
}
