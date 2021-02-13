package com.jm.marketplace.service.city;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.CityDao;
import com.jm.marketplace.dto.CityDto;
import com.jm.marketplace.exception.CityNotFoundException;
import com.jm.marketplace.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private final CityDao cityDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CityServiceImpl(CityDao cityDao, MapperFacade mapperFacade) {
        this.cityDao = cityDao;
        this.mapperFacade = mapperFacade;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CityDto> getAllCity() {
        return mapperFacade.mapAsList(cityDao.findAll(), CityDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public CityDto findById(Long id) {
        City city = cityDao.findById(id).orElseThrow(() ->
                new CityNotFoundException(String.format("City not found by id: %s", id)));
        return mapperFacade.map(city, CityDto.class);
    }
}
