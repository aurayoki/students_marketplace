package com.jm.marketplace.service.goods;

import com.jm.marketplace.dto.goods.GoodsTypeDto;
import com.jm.marketplace.model.goods.GoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsTypeService{
    GoodsTypeDto findById(Long id);

    GoodsTypeDto findByName(String name);
}
