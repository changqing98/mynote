package com.yechangqing.demo.java.springboot.basic.factorybean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
  name = "connect.accountercenter",
  havingValue = "true",
  matchIfMissing = true)
public class AppConfig {

  @Bean
  public AppFactoryBean app() throws Exception {
    return new AppFactoryBean();
  }
}
