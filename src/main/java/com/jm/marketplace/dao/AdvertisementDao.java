package com.jm.marketplace.dao;

import com.jm.marketplace.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdvertisementDao extends JpaRepository<Advertisement, Long>, JpaSpecificationExecutor<Advertisement> {

    @Query(value = "FROM Advertisement AS a WHERE a.active = :active")
    List<Advertisement> findAdvertisementByStatusActive(@Param(value = "active") Boolean active);
}
