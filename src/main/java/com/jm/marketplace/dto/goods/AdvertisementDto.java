package com.jm.marketplace.dto.goods;

import com.jm.marketplace.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDto {
    private Long id;
    private String name;
    private Integer price;
    private String description;
    private UserDto user;
    private String image;
    private LocalDate publication_date;
    private boolean active;
    private boolean expired;
    private boolean banned;
    private GoodsCategoryDto goodsCategory;
    private GoodsSubcategoryDto goodsSubcategory;
    private GoodsTypeDto goodsType;
}
