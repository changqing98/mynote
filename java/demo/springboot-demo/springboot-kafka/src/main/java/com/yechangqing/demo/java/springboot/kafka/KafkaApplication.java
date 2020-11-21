package com.yechangqing.demo.java.springboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class KafkaApplication {
  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(KafkaApplication.class, args);
    Thread.sleep(3000000);
  }
}
