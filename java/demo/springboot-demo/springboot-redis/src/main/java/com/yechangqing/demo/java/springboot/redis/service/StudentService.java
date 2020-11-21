package com.yechangqing.demo.java.springboot.redis.service;

import com.yechangqing.demo.java.springboot.redis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired public RedisTemplate redisTemplate;

  @Cacheable(value = "test", key = "#name")
  public Student test(String name, int age) {
    return new Student(name, age);
  }
}
