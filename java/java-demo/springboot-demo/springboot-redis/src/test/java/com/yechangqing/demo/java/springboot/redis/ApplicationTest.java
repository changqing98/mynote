package com.yechangqing.demo.java.springboot.redis;

import com.yechangqing.demo.java.springboot.redis.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = Application.class)
@ExtendWith(SpringExtension.class)
public class ApplicationTest {

  @Autowired private StudentService studentService;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Test
  public void test() {
    studentService.test("test", 11);
  }

  @Test
  public  void test2(){
    var result = redisTemplate.opsForValue().increment("test3", 0.00001);
    System.out.println(result);
  }
}
