package com.yechangqing.demo.java.basic.java.util.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
  ReentrantLock lock = new ReentrantLock();
  Condition condition = lock.newCondition();

  public void await() throws InterruptedException {
    lock.lock();
    try {
      condition.await();
      System.out.println("Test");
      condition.signal();
    }finally {
      lock.unlock();
    }
  }

  public void signal(){
    condition.signal();
  }

  public static void main(String[] args) throws InterruptedException {
    ConditionDemo demo = new ConditionDemo();
    new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      demo.signal();
    }).start();
    demo.await();
  }
}
