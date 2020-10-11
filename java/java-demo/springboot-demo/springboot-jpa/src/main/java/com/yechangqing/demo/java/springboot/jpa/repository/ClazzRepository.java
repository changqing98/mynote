package com.yechangqing.demo.java.springboot.jpa.repository;

import com.yechangqing.demo.java.springboot.jpa.entity.ClazzEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<ClazzEntity, Long> {}
