package com.jm.marketplace.service.advertisement;

import com.jm.marketplace.dto.goods.AdvertisementDto;

import java.util.List;

public interface AdvertisementService {
    List<AdvertisementDto> findAll();
    AdvertisementDto findById(Long id);
    void saveOrUpdate(AdvertisementDto advertisementDto);
    void deleteById(Long id);
}
