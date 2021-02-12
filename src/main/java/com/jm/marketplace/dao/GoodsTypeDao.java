package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface GoodsTypeDao extends JpaRepository<GoodType, Long> {

    Optional<GoodType> findByName(String name);

    Optional<GoodType> findById(Long id);
}
