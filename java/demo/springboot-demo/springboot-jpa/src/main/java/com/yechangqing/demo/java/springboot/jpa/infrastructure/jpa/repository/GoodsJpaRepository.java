package com.yechangqing.demo.java.springboot.jpa.infrastructure.jpa.repository;

import com.yechangqing.demo.java.springboot.jpa.domain.goods.Goods;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.GoodsId;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.GoodsRepository;
import com.yechangqing.demo.java.springboot.jpa.infrastructure.jpa.dal.GoodsDal;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsJpaRepository implements GoodsRepository {

  private final GoodsDal goodsDal;

  public GoodsJpaRepository(GoodsDal goodsDal) {
    this.goodsDal = goodsDal;
  }

  @Override
  public void save(Goods goods) {
    goodsDal.save(goods);
  }

  @Override
  public Goods find(GoodsId goodsId) {
    return goodsDal.findById(goodsId).get();
  }
}
