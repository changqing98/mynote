package com.yechangqing.demo.java.springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {

  @Before("@annotation(AopTest)")
  public void before(JoinPoint point) {
    System.out.println(point);
    System.out.println("before");
  }
}
