package com.yechangqing.demo.java.springboot.jpa.domain.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "sku")
public class Sku implements Serializable {

  @EmbeddedId
  private SkuId skuId;

  private BigDecimal price;

  private int stock;

  @JoinColumns(@JoinColumn(name = "goods_id"))
  private GoodsId goodsId;

  protected Sku() {
  }

  public Sku(SkuId skuId, BigDecimal price, int stock) {
    this.skuId = skuId;
    this.price = price;
    this.stock = stock;
  }
}
