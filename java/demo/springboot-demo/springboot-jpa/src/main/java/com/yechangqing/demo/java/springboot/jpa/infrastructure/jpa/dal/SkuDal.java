package com.yechangqing.demo.java.springboot.jpa.infrastructure.jpa.dal;

import com.yechangqing.demo.java.springboot.jpa.domain.goods.Sku;
import com.yechangqing.demo.java.springboot.jpa.domain.goods.SkuId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuDal extends JpaRepository<Sku, SkuId> {
}
