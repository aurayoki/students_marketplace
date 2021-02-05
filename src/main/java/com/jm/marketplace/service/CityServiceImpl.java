package com.jm.marketplace.service;

import com.jm.marketplace.dao.CityDao;
import com.jm.marketplace.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private final CityDao cityDao;

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> getAllCity() {
        return cityDao.findAll();
    }
}
