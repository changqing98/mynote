package com.yechangqing.demo.java.basic.java.util.concurrent.locks;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
  Semaphore semaphore = new Semaphore(5);

  public void execute() throws InterruptedException {
    semaphore.acquire();;
    System.out.println(Thread.currentThread().getName());
    Thread.sleep(3000);
    semaphore.release();
  }

  public static void main(String[] args) throws InterruptedException {
    SemaphoreDemo demo = new SemaphoreDemo();
    for(int i = 0;i<20;i++){
      new Thread(() -> {
        try {
          demo.execute();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
    Thread.sleep(12000);
  }
}
