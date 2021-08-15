package com.yechangqing.demo.java.springboot.jpa.domain.goods;

public interface GoodsRepository {
  void save(Goods goods);

  Goods find(GoodsId goodsId);
}
