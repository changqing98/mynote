package com.yechangqing.demo.java.springboot.mybatis.repository;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.yechangqing.demo.java.springboot.mybatis.repository.impl.MybatisPlusRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(MybatisPlusAutoConfiguration.class)
@Import(MybatisPlusRepositoryImpl.class)
public class MybatisPlusRepositoryTest{

  @Autowired  MybatisPlusRepository mybatisPlusRepository;

  @Test
  public void update() {
    mybatisPlusRepository.update(2, 3);
  }
}
