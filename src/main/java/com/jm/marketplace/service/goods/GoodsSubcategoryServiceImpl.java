package com.jm.marketplace.service.goods;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.GoodsCategoryDao;
import com.jm.marketplace.dao.GoodsSubcategoryDao;
import com.jm.marketplace.dto.goods.GoodsSubcategoryDto;
import com.jm.marketplace.exception.GoodsSubcategoryNotFoundException;
import com.jm.marketplace.model.goods.GoodSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsSubcategoryServiceImpl implements GoodsSubcategoryService{
    private final GoodsSubcategoryDao subcategoryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public GoodsSubcategoryServiceImpl(GoodsSubcategoryDao subcategoryDao, MapperFacade mapperFacade) {
        this.subcategoryDao = subcategoryDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public GoodsSubcategoryDto findById(Long id) {
        GoodSubcategory subcategory = subcategoryDao.findById(id).orElseThrow(() -> new GoodsSubcategoryNotFoundException("Not found subcategory"));
        return mapperFacade.map(subcategory, GoodsSubcategoryDto.class);
    }

    @Override
    @Transactional
    public GoodsSubcategoryDto findByName(String name) {
        GoodSubcategory subcategory = subcategoryDao.findByName(name).orElseThrow(() -> new GoodsSubcategoryNotFoundException("Not found subcategory"));
        return mapperFacade.map(subcategory, GoodsSubcategoryDto.class);
    }
}
