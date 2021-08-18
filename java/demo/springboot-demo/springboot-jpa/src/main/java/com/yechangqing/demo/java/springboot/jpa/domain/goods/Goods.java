package com.yechangqing.demo.java.springboot.jpa.domain.goods;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Goods {

  @EmbeddedId
  private GoodsId goodsId;

  private String name;

  private String description;

  @OneToMany
  @JoinColumn(name = "goods_id")
  private List<Sku> skus;

  protected Goods() {
  }

  public Goods(GoodsId goodsId, String name) {
    this.goodsId = goodsId;
    this.name = name;
  }

  public void addSku(Sku sku) {
    if (skus == null) {
      skus = new ArrayList<>();
    }
    skus.add(sku);
  }

  public GoodsId getGoodsId() {
    return goodsId;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public List<Sku> getSkus() {
    return skus;
  }
}
