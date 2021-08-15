package com.yechangqing.demo.java.springboot.jpa.infrastructure.jpa.dal;

import com.yechangqing.demo.java.springboot.jpa.domain.goods.Goods;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.GoodsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDal extends JpaRepository<Goods, GoodsId> {
}
