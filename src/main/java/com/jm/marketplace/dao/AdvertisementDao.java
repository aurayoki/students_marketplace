package com.jm.marketplace.dao;

import com.jm.marketplace.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementDao extends JpaRepository<Advertisement, Long> {
}
