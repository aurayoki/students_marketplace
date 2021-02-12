package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoodsSubcategoryDao extends JpaRepository<GoodSubcategory, Long> {
    @Override
    Optional<GoodSubcategory> findById(Long aLong);

    Optional<GoodSubcategory> findByName(String name);
}
