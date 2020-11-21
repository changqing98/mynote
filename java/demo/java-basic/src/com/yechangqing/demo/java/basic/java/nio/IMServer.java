package com.yechangqing.demo.java.basic.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class IMServer {

  private Selector selector;

  private ServerSocketChannel listenerChannel;

  private static final int PORT = 8888;

  public IMServer() {
    try {
      selector = Selector.open();
      listenerChannel = ServerSocketChannel.open();
      listenerChannel.socket().bind(new InetSocketAddress(PORT));
      listenerChannel.configureBlocking(false);
      listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void listen() throws IOException {
    while (true) {
      int count = selector.select();
      if (count > 0) {
        var it = selector.selectedKeys().iterator();
        while (it.hasNext()) {
          SelectionKey key = it.next();
          if (key.isAcceptable()) {
            SocketChannel sc = listenerChannel.accept();
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
            System.out.println(sc.getRemoteAddress() + "上线");
          } else if (key.isReadable()) {
            doRead(key);
          }
          it.remove();
        }
      }else{
        System.out.println("等待连接...");
      }
    }
  }

  private void doRead(SelectionKey key) {
    SocketChannel channel = (SocketChannel) key.channel();
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    try {
      int count = channel.read(buffer);
      if (count > 0) {
        var msg = new String(buffer.array());
        System.out.println("From客户端: " + msg);
        broadcast(msg, channel);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void broadcast(String message, SocketChannel self) {
    System.out.println("Starts to broadcast");
    SocketChannel sc = null;
    for (SelectionKey key : selector.keys()) {
      try {
        var channel = key.channel();
        if (channel instanceof SocketChannel && channel != self) {
          sc = (SocketChannel) channel;
          var buffer = ByteBuffer.wrap(message.getBytes());
          sc.write(buffer);
        }
      } catch (Exception e) {
        try {
          System.out.println(sc.getRemoteAddress() + "下线");
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    var server = new IMServer();
    try {
      server.listen();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
