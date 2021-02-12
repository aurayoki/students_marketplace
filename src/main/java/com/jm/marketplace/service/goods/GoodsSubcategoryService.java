package com.jm.marketplace.service.goods;

import com.jm.marketplace.dto.goods.GoodsCategoryDto;
import com.jm.marketplace.dto.goods.GoodsSubcategoryDto;

import java.util.List;

public interface GoodsSubcategoryService {
    GoodsSubcategoryDto findById(Long id);

    GoodsSubcategoryDto findByName(String name);
}
