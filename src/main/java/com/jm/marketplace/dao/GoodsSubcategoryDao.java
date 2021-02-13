package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodsSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsSubcategoryDao extends JpaRepository<GoodsSubcategory, Long> {

    @Query(value = "FROM GoodsSubcategory AS g WHERE g.goodsCategory.id = :id")
    List<GoodsSubcategory> findByGoodsCategoryId(@Param(value = "id") Long id);

}
