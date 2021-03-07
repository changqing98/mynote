package com.yechangqing.demo.java.basic.java.lang;

import org.openjdk.jol.info.ClassLayout;

public class ObjectMemoryDistribution {

  private static final Object x = new Object();

  public static void main(String[] args) {
    System.out.print(ClassLayout.parseInstance(x));
  }
}
