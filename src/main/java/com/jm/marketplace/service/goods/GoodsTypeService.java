package com.jm.marketplace.service.goods;

import com.jm.marketplace.dto.goods.GoodsTypeDto;

import java.util.List;

public interface GoodsTypeService {

    List<GoodsTypeDto> findAll();

    List<GoodsTypeDto> findByGoodsSubcategoryId(Long id);

    GoodsTypeDto findById(Long id);

}
