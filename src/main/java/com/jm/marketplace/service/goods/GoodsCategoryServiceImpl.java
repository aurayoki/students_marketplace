package com.jm.marketplace.service.goods;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.GoodsCategoryDao;
import com.jm.marketplace.dto.goods.GoodsCategoryDto;
import com.jm.marketplace.exception.GoodsCategoryNotFoundException;
import com.jm.marketplace.model.goods.GoodsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService{

    private final GoodsCategoryDao goodsCategoryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public GoodsCategoryServiceImpl(GoodsCategoryDao goodsCategoryDao, MapperFacade mapperFacade) {
        this.goodsCategoryDao = goodsCategoryDao;
        this.mapperFacade = mapperFacade;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GoodsCategoryDto> findAll() {
        return mapperFacade.mapAsList(goodsCategoryDao.findAll(), GoodsCategoryDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public GoodsCategoryDto findById(Long id) {
        GoodsCategory goodsCategory = goodsCategoryDao.findById(id).orElseThrow(() ->
                new GoodsCategoryNotFoundException(String.format("Goods category not found by id: %s", id)));
        return mapperFacade.map(goodsCategory, GoodsCategoryDto.class);
    }

}
