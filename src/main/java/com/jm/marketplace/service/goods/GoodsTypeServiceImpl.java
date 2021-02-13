package com.jm.marketplace.service.goods;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.GoodsTypeDao;
import com.jm.marketplace.dto.goods.GoodsTypeDto;
import com.jm.marketplace.exception.GoodsTypeNotFoundException;
import com.jm.marketplace.model.goods.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService{

    private final GoodsTypeDao goodsTypeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public GoodsTypeServiceImpl(GoodsTypeDao goodsTypeDao, MapperFacade mapperFacade) {
        this.goodsTypeDao = goodsTypeDao;
        this.mapperFacade = mapperFacade;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GoodsTypeDto> findAll() {
        return mapperFacade.mapAsList(goodsTypeDao.findAll(), GoodsTypeDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GoodsTypeDto> findByGoodsSubcategoryId(Long id) {
        return mapperFacade.mapAsList(goodsTypeDao.findByGoodsSubcategoryId(id), GoodsTypeDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public GoodsTypeDto findById(Long id) {
        GoodsType goodsType = goodsTypeDao.findById(id).orElseThrow(() ->
                new GoodsTypeNotFoundException(String.format("Goods type not found by id: %s", id)));
        return mapperFacade.map(goodsType, GoodsTypeDto.class);
    }

}
