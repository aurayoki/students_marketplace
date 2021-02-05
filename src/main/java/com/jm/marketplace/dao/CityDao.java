package com.jm.marketplace.dao;

import com.jm.marketplace.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Long> {
}
