package com.yechangqing.demo.java.basic.java.util.concurrent.locks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
  private static final CountDownLatch countDownLatch = new CountDownLatch(100);

  public void await() throws InterruptedException {
    System.out.println(Thread.currentThread().getName());
    countDownLatch.await();
  }

  public void count() throws InterruptedException {
    System.out.println(Thread.currentThread().getName());
    Thread.sleep(1000);
    countDownLatch.countDown();
  }

  public static void main(String[] args) throws InterruptedException {
    CountDownLatchDemo demo = new CountDownLatchDemo();
    int i = 0;
    while(i < 100){
      i++;
      new Thread(() -> {
        try {
          demo.count();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
    demo.await();
    System.out.println("Compelted");
  }
}
