package com.jm.marketplace.util;

import com.jm.marketplace.dao.*;
import com.jm.marketplace.exception.*;
import com.jm.marketplace.model.Advertisement;
import com.jm.marketplace.model.City;
import com.jm.marketplace.model.Role;
import com.jm.marketplace.model.User;
import com.jm.marketplace.model.goods.GoodsCategory;
import com.jm.marketplace.model.goods.GoodsSubcategory;
import com.jm.marketplace.model.goods.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@Order
@Profile(value = "DEV")
public class InitDB {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;
    private final CityDao cityDao;
    private final GoodsCategoryDao goodsCategoryDao;
    private final GoodsSubcategoryDao goodsSubcategoryDao;
    private final GoodsTypeDao goodsTypeDao;
    private final AdvertisementDao advertisementDao;

    @Value("${role.name.admin}")
    private String roleNameAdmin;

    @Value("${role.name.user}")
    private String roleNameUser;

    @Value("${user.name.admin}")
    private String userNameAdmin;

    @Value("${password.default.admin}")
    private String adminPasswordDefault;

    @Value("${email.default.admin}")
    private String adminEmailDefault;

    @Autowired
    public InitDB(UserDao userDao,
                  RoleDao roleDao,
                  PasswordEncoder passwordEncoder,
                  CityDao cityDao,
                  GoodsCategoryDao goodsCategoryDao,
                  GoodsSubcategoryDao goodsSubcategoryDao,
                  GoodsTypeDao goodsTypeDao,
                  AdvertisementDao advertisementDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
        this.cityDao = cityDao;
        this.goodsCategoryDao = goodsCategoryDao;
        this.goodsSubcategoryDao = goodsSubcategoryDao;
        this.goodsTypeDao = goodsTypeDao;
        this.advertisementDao = advertisementDao;
    }

    @Transactional
    public void addRoles() {
        Role roleAdminFromDB = roleDao.findByName(roleNameAdmin).orElse(null);
        if (roleAdminFromDB == null) {
            Role roleAdmin = new Role(roleNameAdmin);
            roleDao.save(roleAdmin);
        }
        Role roleUserFromDB = roleDao.findByName(roleNameUser).orElse(null);
        if (roleUserFromDB == null) {
            Role roleUser = new Role(roleNameUser);
            roleDao.save(roleUser);
        }
    }

    @Transactional
    public void addAdmins() {
        Set<User> usersAdmin = userDao.findAll().stream()
                .filter(user -> user.getFirstName().equals(userNameAdmin))
                .collect(Collectors.toSet());
        if (usersAdmin.isEmpty()) {
            User userAdmin = new User(userNameAdmin,
                    userNameAdmin,
                    passwordEncoder.encode(adminPasswordDefault),
                    adminEmailDefault);
            Role roleAdmin = roleDao.findByName(roleNameAdmin).orElseThrow(() ->
                    new RoleNotFoundException("Role admin not found!"));
            userAdmin.setRoles(Set.of(roleAdmin));
            userDao.save(userAdmin);
        }
    }

    @Transactional
    public void addCities() {
        if (cityDao.findAll().isEmpty()) {
            City cityMoscow = new City("Moscow");
            cityDao.save(cityMoscow);
        }
    }

    @Transactional
    public void addGoodsCategory() {
        if (goodsCategoryDao.findAll().isEmpty()) {
            goodsCategoryDao.save(new GoodsCategory("Транспорт"));
            goodsCategoryDao.save(new GoodsCategory("Недвижимость"));
            goodsCategoryDao.save(new GoodsCategory("Работа"));
            goodsCategoryDao.save(new GoodsCategory("Услуги"));
            goodsCategoryDao.save(new GoodsCategory("Личные вещи"));
            goodsCategoryDao.save(new GoodsCategory("Для дома и дачи"));
            goodsCategoryDao.save(new GoodsCategory("Бытовая электроника"));
            goodsCategoryDao.save(new GoodsCategory("Хобби и отдых"));
            goodsCategoryDao.save(new GoodsCategory("Животные"));
            goodsCategoryDao.save(new GoodsCategory("Готовый бизнес и оборудование"));
        }
    }

    @Transactional
    public void addGoodsSubcategory() {
        if (goodsSubcategoryDao.findAll().isEmpty()) {
            GoodsCategory goodsCategory = goodsCategoryDao.findByName("Бытовая электроника").orElseThrow(() ->
                    new GoodsCategoryNotFoundException("Goods category not found"));
            goodsSubcategoryDao.save(new GoodsSubcategory("Аудио и видео", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Игры, приставки и программы", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Настольные компьютеры", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Ноутбуки", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Оргтехника и расходника", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Планшеты и электронные книги", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Телефоны", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Товары для компьютера", goodsCategory));
            goodsSubcategoryDao.save(new GoodsSubcategory("Фототехника", goodsCategory));
        }
    }

    @Transactional
    public void addGoodsType() {
        if (goodsTypeDao.findAll().isEmpty()) {
            GoodsSubcategory goodsSubcategory = goodsSubcategoryDao.findByName("Товары для компьютера").orElseThrow(() ->
                    new GoodsSubcategoryNotFoundException("Goods subcategory not found"));
            goodsTypeDao.save(new GoodsType("Акустика", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Веб-камеры", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Джойстики и рули", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Клавиатуры и мыши", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Комплектующие", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Мониторы", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Переносные жесткие диски", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Сетевое оборудование", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("ТВ-тюнеры", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Флешки и карты памяти", goodsSubcategory));
            goodsTypeDao.save(new GoodsType("Аксессуары", goodsSubcategory));
        }
    }

    @Transactional
    public void addAdvertisement() {
        if (advertisementDao.findAll().isEmpty()) {
            GoodsCategory goodsCategory = goodsCategoryDao.findByName("Бытовая электроника").orElseThrow(() ->
                    new GoodsCategoryNotFoundException("Goods category not found"));
            GoodsSubcategory goodsSubcategory = goodsSubcategoryDao.findByName("Товары для компьютера").orElseThrow(() ->
                    new GoodsSubcategoryNotFoundException("Goods subcategory not found"));
            GoodsType goodsType = goodsTypeDao.findByName("Комплектующие").orElseThrow(() ->
                    new GoodsTypeNotFoundException("Goods type not found"));
            User user = userDao.findByEmail(adminEmailDefault).orElseThrow(() ->
                    new UserNotFoundException("User not found"));
            advertisementDao.save(new Advertisement("Компьютер AMD",
                    16000, "В идеальном состоянии включался один раз",
                    goodsCategory, goodsSubcategory, goodsType, user));
            advertisementDao.save(new Advertisement("AM4",
                    18000, "Материнская плата",
                    goodsCategory, goodsSubcategory, goodsType, user));
            advertisementDao.save(new Advertisement("Ноутбук lenovo",
                    23000, "для игр и работы",
                    goodsCategory, goodsSubcategory, goodsType, user));
            advertisementDao.save(new Advertisement("Монитор AOC CQ32",
                    21000, "Игровой",
                    goodsCategory, goodsSubcategory, goodsType, user));
        }
    }
}
