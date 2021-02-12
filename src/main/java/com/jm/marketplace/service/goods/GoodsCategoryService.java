package com.jm.marketplace.service.goods;

import com.jm.marketplace.dto.goods.GoodsCategoryDto;
import com.jm.marketplace.dto.goods.GoodsSubcategoryDto;
import com.jm.marketplace.dto.goods.GoodsTypeDto;

import java.util.List;

public interface GoodsCategoryService {
    GoodsCategoryDto findById(Long id);

    GoodsCategoryDto findByName(String name);
}
