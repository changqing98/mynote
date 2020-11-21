package com.yechangqing.demo.java.springboot.jpa.service;

import com.yechangqing.demo.java.springboot.jpa.SpringbootApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest extends SpringbootApplicationTest {

  @Autowired
  private AccountService accountService;

  @Test
  public void update() {
    accountService.update(1, 2);
  }

  @Test
  public void save() {
    accountService.save(1,10);
    System.out.println(true);
  }
}
