package com.yechangqing.demo.java.springboot.jpa.service;

import com.yechangqing.demo.java.springboot.jpa.entity.AccountEntity;
import com.yechangqing.demo.java.springboot.jpa.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void update(int id, int num) {
    try {
      Thread.sleep(50);
      accountRepository.update(id, num);
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void save(int id, int num) {
    accountRepository.save(new AccountEntity(id, num));
  }
}
