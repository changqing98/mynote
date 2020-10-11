package com.yechangqing.demo.java.springboot.jpa.repository;

import com.yechangqing.demo.java.springboot.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
