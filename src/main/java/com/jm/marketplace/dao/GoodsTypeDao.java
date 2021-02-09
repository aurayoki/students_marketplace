package com.jm.marketplace.dao;

import com.jm.marketplace.model.goods.GoodType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoodsType extends JpaRepository<GoodsType, Long> {
    List<Optional<GoodType>> findAllByName();
}
