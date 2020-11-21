package com.yechangqing.demo.java.springboot.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "account")
public class AccountEntity {
  @Id
  @GeneratedValue
  private int id;
  private int balance;

  public AccountEntity(){

  }

  public AccountEntity(int id, int balance) {
    this.id = id;
    this.balance = balance;
  }
}
