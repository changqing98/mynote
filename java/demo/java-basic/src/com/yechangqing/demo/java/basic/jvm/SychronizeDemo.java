package com.yechangqing.demo.java.basic.jvm;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SychronizeDemo {

  private volatile int i = 0;

  public void increase() {
      i++;
  }

  public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    var demo = new SychronizeDemo();
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    new Thread(() -> {
      for (int i = 0; i < 10000; i++) {
        demo.increase();
      }
      try {
        cyclicBarrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }).start();
    for (int i = 0; i < 10000; i++) {
      demo.increase();
    }
    cyclicBarrier.await();
    System.out.println(demo.i);
  }
}
