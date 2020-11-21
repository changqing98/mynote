package com.yechangqing.demo.java.springboot.basic.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements InitializingBean, BeanPostProcessor, BeanFactoryPostProcessor, InstantiationAwareBeanPostProcessor {
  public TestBean() {
    System.out.println("Construction function");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("InitializingBean afterPropertiesSet");
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("BeanPostProcessor postProcessBeforeInitialization");
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("BeanPostProcessor postProcessAfterInitialization");
    return bean;
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    System.out.println("BeanFactoryPostProcessor postProcessBeanFactory");
  }
}
