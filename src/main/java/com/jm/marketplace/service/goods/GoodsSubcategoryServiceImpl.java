package com.jm.marketplace.service.goods;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.GoodsSubcategoryDao;
import com.jm.marketplace.dto.goods.GoodsSubcategoryDto;
import com.jm.marketplace.exception.GoodsSubcategoryNotFoundException;
import com.jm.marketplace.model.goods.GoodsSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsSubcategoryServiceImpl implements GoodsSubcategoryService{

    private final GoodsSubcategoryDao goodsSubcategoryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public GoodsSubcategoryServiceImpl(GoodsSubcategoryDao goodsSubcategoryDao, MapperFacade mapperFacade) {
        this.goodsSubcategoryDao = goodsSubcategoryDao;
        this.mapperFacade = mapperFacade;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GoodsSubcategoryDto> findAll() {
        return mapperFacade.mapAsList(goodsSubcategoryDao.findAll(), GoodsSubcategoryDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GoodsSubcategoryDto> findByGoodsCategoryId(Long id) {
        return mapperFacade.mapAsList(goodsSubcategoryDao.findByGoodsCategoryId(id), GoodsSubcategoryDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public GoodsSubcategoryDto findById(Long id) {
        GoodsSubcategory goodsSubcategory = goodsSubcategoryDao.findById(id).orElseThrow(() ->
                new GoodsSubcategoryNotFoundException(String.format("Goods subcategory not found by id: %s", id)));
        return mapperFacade.map(goodsSubcategory, GoodsSubcategoryDto.class);
    }

}
