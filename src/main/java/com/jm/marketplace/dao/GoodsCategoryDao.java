package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCategoryDao extends JpaRepository<GoodsCategory, Long> {
}
