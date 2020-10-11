package com.yechangqing.demo.java.springboot.jpa.repository;

import com.yechangqing.demo.java.springboot.jpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

  @Modifying
  @Query("update AccountEntity a set a.balance = a.balance + :num where a.id = :id")
  @Transactional
  void update(@Param("id") int id, @Param("num") int num);
}
