package com.jm.marketplace.service.goods;

import com.jm.marketplace.dto.goods.GoodsCategoryDto;

import java.util.List;

public interface GoodsCategoryService {

    List<GoodsCategoryDto> findAll();

    GoodsCategoryDto findById(Long id);

}
