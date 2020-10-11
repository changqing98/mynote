package com.yechangqing.demo.java.basic.java.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.regex.Pattern;

public class ServerSocketChannelDemo {
  private static int port = 8899;
  private final static Charset charset = StandardCharsets.UTF_8;
  private static final CharsetEncoder encoder = charset.newEncoder();

  private static ServerSocketChannel setup() throws IOException {
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    var host = InetAddress.getLocalHost().getHostAddress();
    System.out.printf("Host:%s", host);
    serverSocketChannel.socket().bind(new InetSocketAddress(host, port));
    serverSocketChannel.configureBlocking(false);
    return serverSocketChannel;
  }

  private static void start(ServerSocketChannel ssc) throws IOException {
    try (SocketChannel sc = ssc.accept()) {
      if(sc != null){
        String now = new Date().toString();
        sc.write(encoder.encode(CharBuffer.wrap(now + "\r\n")));
        System.out.println(sc.socket().getInetAddress() + " : " + now);
      }
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    if (args.length > 1) {
      System.err.println("Usage: java TimeServer [port]");
      return;
    }
    // If the first argument is a string of digits then we take that
    // to be the port number
    if ((args.length == 1) && Pattern.matches("[0-9]+", args[0])) {
      port = Integer.parseInt(args[0]);
    }
    ServerSocketChannel ssc = setup();
    for (;;) {
      System.out.println("Waitting for connections...");
      start(ssc);
      Thread.sleep(3000);
    }
  }


}
