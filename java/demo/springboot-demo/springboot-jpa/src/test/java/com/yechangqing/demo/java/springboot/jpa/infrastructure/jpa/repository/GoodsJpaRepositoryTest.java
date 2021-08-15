package com.yechangqing.demo.java.springboot.jpa.infrastructure.jpa.repository;

import com.yechangqing.demo.java.springboot.jpa.domain.goods.Goods;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.GoodsId;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.Sku;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.SkuId;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(GoodsJpaRepository.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class GoodsJpaRepositoryTest {

  @Autowired
  private GoodsJpaRepository goodsJpaRepository;

  @Test
  void save() {
    var goodsId = new GoodsId(123L);
    var goodsName = "测试商品";
    var goods = new Goods(goodsId, "测试商品");
    var sku = new Sku(new SkuId(1234L), BigDecimal.valueOf(9.9), 100);
    goods.addSku(sku);
    goodsJpaRepository.save(goods);
//    goods = goodsJpaRepository.find(goodsId);
//    Assertions.assertEquals(goodsName, goods.getName());
  }
}
