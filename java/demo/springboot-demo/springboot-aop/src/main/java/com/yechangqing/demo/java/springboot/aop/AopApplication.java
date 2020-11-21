package com.yechangqing.demo.java.springboot.aop;

import com.yechangqing.demo.java.springboot.aop.service.ServiceDemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootConfiguration
@ComponentScan("com.yechangqing.demo.java.springboot.aop")
public class AopApplication implements CommandLineRunner {

  private final ServiceDemo serviceDemo;

  public AopApplication(ServiceDemo serviceDemo) {
    this.serviceDemo = serviceDemo;
  }

  public static void main(String[] args) {
    var application = new SpringApplication(AopApplication.class).run(args);
    System.out.println(application);
  }

  @Override
  public void run(String... args) {
    serviceDemo.aopTest();
  }
}
