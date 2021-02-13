package com.jm.marketplace.service.advertisement;

import com.jm.marketplace.dto.goods.AdvertisementDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface AdvertisementService {

    List<AdvertisementDto> findAll();

    Page<AdvertisementDto> findAll(Integer page);

    Page<AdvertisementDto> findAll(Integer page, Map<String, String> params);

    AdvertisementDto findById(Long id);

    void saveOrUpdate(AdvertisementDto advertisementDto);

    void deleteById(Long id);

    List<AdvertisementDto> findAdvertisementByStatusActive(Boolean field_value);
}
