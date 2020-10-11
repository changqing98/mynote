package com.yechangqing.demo.java.springboot.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    name = "user",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"userName", "organization"})})
public class UserEntity {

  @Id @GeneratedValue private Long id;

  @Column(length = 20)
  private String userName;

  @Column(length = 20)
  private String organization;

  @Column(length = 20)
  private Integer age;

  @Column(length = 30)
  private String email;

  @Column(length = 11)
  private String mobile;

  @Column(length = 30)
  private String address;

  @Column(unique = true)
  private String idCardNum;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getIdCardNum() {
    return idCardNum;
  }

  public void setIdCardNum(String idCardNum) {
    this.idCardNum = idCardNum;
  }
}
