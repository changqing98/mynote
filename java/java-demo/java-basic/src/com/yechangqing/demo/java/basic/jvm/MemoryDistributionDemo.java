package com.yechangqing.demo.java.basic.jvm;

import java.util.ArrayList;
import java.util.List;

public class MemoryDistributionDemo {

  private List<Thread> list = new ArrayList<>();

  public void add(Thread thread) {
    list.add(thread);
  }

  public static void main(String[] args) throws InterruptedException {
    var test = new MemoryDistributionDemo();
    while (true) {
      Thread.sleep(50);
      test.add(new Thread());
    }
  }
}
