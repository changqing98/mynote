package com.yechangqing.demo.java.basic.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSC = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSC.socket();
        serverSocket.bind(new InetSocketAddress("localhost", 8888));
        Socket socket = serverSocket.accept();
        
    }
    
}