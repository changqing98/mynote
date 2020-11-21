package com.yechangqing.demo.java.basic.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class IMClient {

  private final String host = "127.0.0.1";
  private final int port = 8888;
  private Selector selector;
  private SocketChannel socketChannel;
  private String username;

  public IMClient() {
    try {
      selector = Selector.open();
      socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
      socketChannel.configureBlocking(false);
      socketChannel.register(selector, SelectionKey.OP_READ);

      username = socketChannel.getLocalAddress().toString().substring(1);
      System.out.println(username + " is ok");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void send(String message) {
    var info = username + ":" + message;
    try {
      socketChannel.write(ByteBuffer.wrap(message.getBytes()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void read() {
    try {
      int count = selector.select();
      if (count > 0) {
        var it = selector.selectedKeys().iterator();
        while (it.hasNext()) {
          var key = it.next();
          if (key.isReadable()) {
            var channel = key.channel();
            var buffer = ByteBuffer.allocate(1024);
            var sc = (SocketChannel) channel;
            sc.read(buffer);
            System.out.println(sc.getRemoteAddress() + " : " + new String(buffer.array()));
          }
          it.remove();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    var client = new IMClient();
    new Thread(() -> {
      while(true){
        client.read();
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    var scanner = new Scanner(System.in);
    while (scanner.hasNext()){
      String s = scanner.nextLine();
      client.send(s);
    }
  }
}
