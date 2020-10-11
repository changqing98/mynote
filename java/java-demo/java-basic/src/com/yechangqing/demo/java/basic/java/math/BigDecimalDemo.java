package com.yechangqing.demo.java.basic.java.math;

import java.math.BigDecimal;

public class BigDecimalDemo {
  public static void main(String[] args) {
    var d = 0.05;
    System.out.println(d);
    System.out.println(d - 0.001);
    var balance = BigDecimal.valueOf(128.96);
    System.out.println(balance);
    var result = balance.subtract(BigDecimal.valueOf(0.005));
    System.out.println(result);
  }
}
