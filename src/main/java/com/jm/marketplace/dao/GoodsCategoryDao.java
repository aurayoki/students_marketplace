package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoodsCategoryDao extends JpaRepository<GoodCategory, Long> {
    @Override
    Optional<GoodCategory> findById(Long aLong);

    Optional<GoodCategory> findByName(String name);
}
