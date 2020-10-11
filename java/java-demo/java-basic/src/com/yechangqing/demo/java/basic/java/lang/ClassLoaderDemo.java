package com.yechangqing.demo.java.basic.java.lang;

class C1 {
  static C2 c2 = new C2();

  static {
    System.out.println("I am static block C1");
  }

  {
    System.out.println("I am free block C1");
  }

  public C1() {
    System.out.println("I am constructor C1");
  }
}

class C2 {
  static {
    System.out.println("I am static block C2");
  }

  {
    System.out.println("I am free block C2");
  }

  public C2() {
    System.out.println("I am constructor C2");
  }
}

public class ClassLoaderDemo {
  public static void main(String[] args) {
    new C1();
  }
}
