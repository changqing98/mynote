package com.yechangqing.demo.java.basic.java.lang;

import java.lang.reflect.Field;

public class StringDemo {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    String str = "hello world!";
    Field valueField = str.getClass().getDeclaredField("value");
    valueField.setAccessible(true);
    byte[] value = (byte[]) valueField.get(str);

    for (byte x : value) {
//      System.out.println(x);
      System.out.println((char) x);
    }
  }
}
