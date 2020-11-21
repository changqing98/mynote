package com.yechangqing.demo.java.springboot.mybatis.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yechangqing.demo.java.springboot.mybatis.entity.AccountEntity;
import com.yechangqing.demo.java.springboot.mybatis.mapper.MybatisPlusDemoMapper;
import com.yechangqing.demo.java.springboot.mybatis.repository.MybatisPlusRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisPlusRepositoryImpl extends ServiceImpl<MybatisPlusDemoMapper, AccountEntity>
    implements MybatisPlusRepository {

  @Override
  public boolean update(int id, int num) {
    return baseMapper.updateBalance(id, num);
  }
}
