package com.yechangqing.demo.java.basic.java.util.concurrent.locks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

  public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    cyclicBarrier.await();

  }
}
