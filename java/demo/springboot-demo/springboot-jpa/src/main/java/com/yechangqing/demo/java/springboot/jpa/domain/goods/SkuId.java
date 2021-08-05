package com.yechangqing.demo.java.springboot.jpa.domain.goods;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class SkuId implements Serializable {
  private long skuId;

  public SkuId(long skuId) {
    this.skuId = skuId;
  }

  protected SkuId() {
  }

  public long getSkuId() {
    return skuId;
  }
}
