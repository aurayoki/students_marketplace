package com.jm.marketplace.dto.goods;

import com.jm.marketplace.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private GoodsCategoryDto goodsCategory;
    private GoodsSubcategoryDto goodsSubcategory;
    private GoodsTypeDto goodsType;
}
