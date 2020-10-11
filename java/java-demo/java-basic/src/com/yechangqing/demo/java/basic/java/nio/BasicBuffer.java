package com.yechangqing.demo.java.basic.java.nio;

import java.nio.IntBuffer;

public class BasicBuffer {
  public static void main(String[] args) {
    IntBuffer intBf = IntBuffer.allocate(10);

    for (int i = 0; i < intBf.capacity(); i++) {
      intBf.put(i * 2);
    }

    // 将position置为0
    intBf.flip();
    for (int i = 0; i < intBf.capacity(); i++) {
      intBf.put(i * 3);
    }
    // 将position置为0
    intBf.flip();
    for (int i = 0; i < intBf.capacity(); i++) {
      System.out.println(intBf.get());
    }
  }
}
