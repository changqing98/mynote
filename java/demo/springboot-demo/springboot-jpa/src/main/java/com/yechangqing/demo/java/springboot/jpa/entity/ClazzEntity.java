package com.yechangqing.demo.java.springboot.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    name = "clazz",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"grade", "clazz"})})
public class ClazzEntity {

  @Id @GeneratedValue private Long id;

  @Column(length = 20)
  private String grade;

  @Column(length = 20)
  private String clazz;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }
}
