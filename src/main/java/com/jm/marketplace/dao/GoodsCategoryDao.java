package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodsCategoryDao extends JpaRepository<GoodsCategory, Long> {
    Optional<GoodsCategory> findByName(String name);
}
