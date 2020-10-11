package com.yechangqing.demo.java.basic.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
  ReentrantLock lock = new ReentrantLock();
  public int count = 0;

  public void decrease() {
    synchronized (this){
      for(int i=1; i<=5; i++){
        System.out.println(Thread.currentThread().getName() + ":" + count--);
      }
    }
  }

  public synchronized void increase() {
    lock.lock();
    try{
      for(int i=1; i<=5; i++){
        System.out.println(Thread.currentThread().getName() + ":" + count++);
      }
    }finally {
      lock.unlock();
    }
  }


  public static void main(String[] args) throws InterruptedException {
    ReentrantLockDemo test = new ReentrantLockDemo();
    new Thread(test::increase).start();
    new Thread(test::increase).start();
    Thread.sleep(1000);
    System.out.println(test.count);
  }
}
