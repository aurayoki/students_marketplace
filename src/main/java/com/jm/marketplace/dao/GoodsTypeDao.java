package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsTypeDao extends JpaRepository<GoodsType, Long> {
    List<GoodsType> findAllByName(String name);

    @Query(value = "FROM GoodsType AS g WHERE g.goodsSubcategory.id = :id")
    List<GoodsType> findByGoodsSubcategoryId(Long id);
}
