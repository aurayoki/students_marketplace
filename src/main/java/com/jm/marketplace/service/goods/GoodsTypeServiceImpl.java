package com.jm.marketplace.service.goods;

import com.jm.marketplace.dao.GoodsTypeDao;
import com.jm.marketplace.dto.goods.GoodsTypeDto;
import com.jm.marketplace.exception.GoodsTypeNotFoundException;
import com.jm.marketplace.model.goods.GoodType;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService{
    private final GoodsTypeDao typeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public GoodsTypeServiceImpl(GoodsTypeDao typeDao, MapperFacade mapperFacade) {
        this.typeDao = typeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public GoodsTypeDto findById(Long id) {
        GoodType type = typeDao.findById(id).orElseThrow(() -> new GoodsTypeNotFoundException("Not found type"));
        return mapperFacade.map(type, GoodsTypeDto.class);
    }

    @Override
    @Transactional
    public GoodsTypeDto findByName(String name) {
        GoodType type = typeDao.findByName(name).orElseThrow(() -> new GoodsTypeNotFoundException("Not found type"));
        return mapperFacade.map(type, GoodsTypeDto.class);
    }
}
