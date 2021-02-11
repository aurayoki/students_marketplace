package com.jm.marketplace.service.advertisement;

import com.jm.marketplace.dto.goods.AdvertisementDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdvertisementService {
    List<AdvertisementDto> findAll();
    Page<AdvertisementDto> findAllWithPagination(Integer page);
    AdvertisementDto findById(Long id);
    void saveOrUpdate(AdvertisementDto advertisementDto);
    void deleteById(Long id);
}
