package com.yechangqing.demo.java.springboot.jpa.repository;

import com.yechangqing.demo.java.springboot.jpa.SpringbootApplicationTest;
import com.yechangqing.demo.java.springboot.jpa.entity.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTest extends SpringbootApplicationTest {

  @Autowired private UserRepository userRepository;

  @Test
  public void save() {
    UserEntity user = new UserEntity();
    user.setUserName("changqing");
    user.setEmail("ab.com");
    UserEntity user2 = new UserEntity();
    user.setUserName("changqin1");
    user.setEmail("2");
    UserEntity user3 = new UserEntity();
    user.setUserName("changqin2");
    user.setEmail("3");
    List<UserEntity> list = new ArrayList<>();
    list.add(user);
    list.add(user2);
    list.add(user3);
    userRepository.saveAll(list);
    Long result = user.getId();
    System.out.println(result);
  }
}
