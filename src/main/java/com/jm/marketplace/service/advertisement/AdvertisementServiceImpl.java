package com.jm.marketplace.service.advertisement;

import com.jm.marketplace.dto.goods.AdvertisementDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Override
    public List<AdvertisementDto> findAll() {
        return null;
    }

    @Override
    public AdvertisementDto findById(Long id) {
        return null;
    }

    @Override
    public void saveOrUpdate(AdvertisementDto advertisementDto) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
