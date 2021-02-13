package com.jm.marketplace.dto.goods;

import com.jm.marketplace.model.goods.GoodsSubcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsTypeDto {
    private Long id;
    private String name;
    private GoodsSubcategoryDto goodsSubcategory;
}
