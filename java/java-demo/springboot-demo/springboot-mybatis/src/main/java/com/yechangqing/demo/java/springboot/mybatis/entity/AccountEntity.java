package com.yechangqing.demo.java.springboot.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("account")
public class AccountEntity {
  private int id;
  private int balance;

  public AccountEntity() {}

  public AccountEntity(int id, int balance) {
    this.id = id;
    this.balance = balance;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
