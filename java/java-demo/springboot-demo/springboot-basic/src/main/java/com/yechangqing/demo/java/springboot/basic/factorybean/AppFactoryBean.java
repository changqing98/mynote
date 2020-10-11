package com.yechangqing.demo.java.springboot.basic.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;

public class AppFactoryBean implements FactoryBean<App> {

  @Value("${app.id:10}")
  private int appId;

  @Override
  public App getObject() throws Exception {
    var app =  new App(appId);
    System.out.println(app);
    return app;
  }

  @Override
  public Class<?> getObjectType() {
    return App.class;
  }
}
