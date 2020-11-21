package com.yechangqing.demo.java.springboot.aop.service;

import com.yechangqing.demo.java.springboot.aop.aspect.AopTest;
import org.springframework.stereotype.Service;

@Service
public class ServiceDemoImpl implements ServiceDemo {
  @AopTest
  public void aopTest() {
    System.out.println("Aop test");
  }
}
