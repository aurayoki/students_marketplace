package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsTypeDao extends JpaRepository<GoodsTypeDao, Long> {
    List<GoodsType> findAllByName();
}
