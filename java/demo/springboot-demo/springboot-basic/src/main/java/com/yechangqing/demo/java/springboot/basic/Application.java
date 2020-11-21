package com.yechangqing.demo.java.springboot.basic;

import com.yechangqing.demo.java.springboot.basic.factorybean.App;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private final App app;

  public Application(App app) {
    this.app = app;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) {
    System.out.println(app.getId());
  }
}
