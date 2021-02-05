package com.jm.marketplace.model;

import com.jm.marketplace.model.goods.GoodCategory;
import com.jm.marketplace.model.goods.GoodSubcategory;
import com.jm.marketplace.model.goods.GoodType;

import javax.persistence.*;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String desription;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_category_id", nullable = false)
    private GoodCategory goodCategory;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_subcategory_id", nullable = false)
    private GoodSubcategory goodSubcategory;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_type_id", nullable = false)
    private GoodType goodType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public GoodCategory getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(GoodCategory goodCategory) {
        this.goodCategory = goodCategory;
    }

    public GoodSubcategory getGoodSubcategory() {
        return goodSubcategory;
    }

    public void setGoodSubcategory(GoodSubcategory goodSubcategory) {
        this.goodSubcategory = goodSubcategory;
    }

    public GoodType getGoodType() {
        return goodType;
    }

    public void setGoodType(GoodType goodType) {
        this.goodType = goodType;
    }
}
