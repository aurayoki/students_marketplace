package com.jm.marketplace.service.city;

import com.jm.marketplace.dto.CityDto;
import com.jm.marketplace.model.City;

import java.util.List;

public interface CityService {

    List<CityDto> getAllCity();

    CityDto findById(Long id);
}
