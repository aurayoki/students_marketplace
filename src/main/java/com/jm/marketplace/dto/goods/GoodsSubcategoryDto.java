package com.jm.marketplace.dto.goods;

import com.jm.marketplace.model.goods.GoodsCategory;
import com.jm.marketplace.model.goods.GoodsType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsSubcategoryDto {
    private Long id;
    private String name;
    private GoodsCategoryDto goodsCategory;
}
