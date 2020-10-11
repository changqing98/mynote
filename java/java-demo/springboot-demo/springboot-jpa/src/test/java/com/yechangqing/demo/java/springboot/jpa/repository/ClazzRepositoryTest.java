package com.yechangqing.demo.java.springboot.jpa.repository;

import com.yechangqing.demo.java.springboot.jpa.SpringbootApplicationTest;
import com.yechangqing.demo.java.springboot.jpa.entity.ClazzEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClazzRepositoryTest extends SpringbootApplicationTest {

  @Autowired private ClazzRepository clazzRepository;

  @Test
  public void save() {
    ClazzEntity clazz = new ClazzEntity();
    clazz.setClazz("clazz");
    clazz.setGrade("grade");
    clazzRepository.save(clazz);
    Long result = clazz.getId();
    System.out.println(result);
  }
}
