package com.yechangqing.demo.java.basic.java.lang;

class TestException {
  public void doSomething() {
    int a = 1/ 0;
  }
}

class MyException extends RuntimeException {
  @Override
  public void printStackTrace() {
    super.printStackTrace();
  }
}

public class ExceptionDemo {

  public static void main(String[] args) {
    var test = new TestException();
    test.doSomething();
  }
}
