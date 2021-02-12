package com.jm.marketplace.dao;

import com.jm.marketplace.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdvertisementDao extends JpaRepository<Advertisement, Long>, JpaSpecificationExecutor<Advertisement> {
}
