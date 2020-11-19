package com.yechangqing.demo.alipay;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class AlipayTradePagePayBizContent {

  @JSONField(name = "out_trade_no")
  private String outTradeNo;

  @JSONField(name = "product_code")
  private String productCode;

  @JSONField(name = "total_amount")
  private BigDecimal totalAmount;

  private String subject;

  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
