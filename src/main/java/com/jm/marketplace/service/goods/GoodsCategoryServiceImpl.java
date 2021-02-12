package com.jm.marketplace.service.goods;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.GoodsCategoryDao;
import com.jm.marketplace.dto.goods.GoodsCategoryDto;
import com.jm.marketplace.dto.goods.GoodsSubcategoryDto;
import com.jm.marketplace.exception.GoodsCategoryNotFoundException;
import com.jm.marketplace.model.goods.GoodCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsCategoryServiceImpl implements  GoodsCategoryService{
    private final GoodsCategoryDao categoryDao;
    private final MapperFacade mapperFacade;

    public GoodsCategoryServiceImpl(GoodsCategoryDao categoryDao, MapperFacade mapperFacade) {
        this.categoryDao = categoryDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public GoodsCategoryDto findById(Long id) {
        GoodCategory category = categoryDao.findById(id).orElseThrow(() -> new GoodsCategoryNotFoundException("Not found category"));
        return mapperFacade.map(category, GoodsCategoryDto.class);
    }

    @Override
    @Transactional
    public GoodsCategoryDto findByName(String name) {
        GoodCategory category = categoryDao.findByName(name).orElseThrow(() -> new GoodsCategoryNotFoundException("Not found category"));
        return mapperFacade.map(category, GoodsCategoryDto.class);
    }
}
