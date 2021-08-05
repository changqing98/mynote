package com.yechangqing.demo.java.springboot.jpa.domain.goods;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class GoodsId implements Serializable {
  private long goodsId;

  public GoodsId(long goodsId) {
    this.goodsId = goodsId;
  }

  protected GoodsId() {
  }
}
