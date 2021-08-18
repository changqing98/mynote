package com.yechangqing.demo.java.springboot.jpa.infrastructure.jpa.dal;

import com.yechangqing.demo.java.springboot.jpa.domain.goods.Goods;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.GoodsId;
import org.springframework.data.repository.CrudRepository;

public interface  GoodsDal extends CrudRepository<Goods, GoodsId> {
}
