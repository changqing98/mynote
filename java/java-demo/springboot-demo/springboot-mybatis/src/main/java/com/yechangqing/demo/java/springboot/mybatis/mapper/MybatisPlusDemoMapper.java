package com.yechangqing.demo.java.springboot.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yechangqing.demo.java.springboot.mybatis.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface MybatisPlusDemoMapper extends BaseMapper<AccountEntity> {
  @Update("update account set balance = balance + #{num} where id = #{id}")
  boolean updateBalance(@Param("id") int id, @Param("num") int num);
}
