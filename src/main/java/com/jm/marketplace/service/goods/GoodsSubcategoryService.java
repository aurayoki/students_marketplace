package com.jm.marketplace.service.goods;

import com.jm.marketplace.dto.goods.GoodsSubcategoryDto;

import java.util.List;

public interface GoodsSubcategoryService {

    List<GoodsSubcategoryDto> findAll();

    List<GoodsSubcategoryDto> findByGoodsCategoryId(Long id);

    GoodsSubcategoryDto findById(Long id);

}
