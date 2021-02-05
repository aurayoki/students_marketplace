package com.jm.marketplace.dao;

import com.jm.marketplace.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Long> {
}
