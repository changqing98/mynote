package com.yechangqing.demo.java.basic.java.lang;

import java.util.ArrayList;

public class ObjectDemo {

  public static void main(String[] args) throws InterruptedException {
    var list = new ArrayList<Integer>();
    // class java.util.ArrayList
    System.out.println(list.getClass());
    FinalizeDemo test = new FinalizeDemo();
    test = null;
    Thread.sleep(100000);
  }

  public static class FinalizeDemo {
    public String[] arary = new String[100000];
    @Override
    protected void finalize() throws Throwable {
      System.out.println("调用了fianalize");
    }
  }
}
