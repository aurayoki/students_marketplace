package com.jm.marketplace.config;

import com.jm.marketplace.util.InitDB;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "DEV")
public class TestConfig {

    public TestConfig(InitDB initDB) {
        initDB.addRoles();
        initDB.addAdmins();
        initDB.addCities();
        initDB.addGoodsCategory();
        initDB.addGoodsSubcategory();
        initDB.addGoodsType();
        initDB.addAdvertisement();
    }
}
