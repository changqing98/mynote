package com.yechangqing.demo.java.springboot.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringBootOauthApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootOauthApplication.class, args);
  }
}
