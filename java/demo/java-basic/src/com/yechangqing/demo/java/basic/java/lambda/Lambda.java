package com.yechangqing.demo.java.basic.java.lambda;

import java.util.function.Consumer;

public class Lambda {
  public interface Test {
    void test(int x);
  }

  public static void main(String[] args) {
    Test x = System.out::println;
    x.test(3);
    Consumer<String> consumer = System.out::println;
  }
}
