package com.jm.marketplace.models;

import javax.persistence.*;

@Entity
public class advertisement {

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
    private goodCategory goodCategory;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_subcategory_id", nullable = false)
    private goodSubcategory goodSubcategory;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_type_id", nullable = false)
    private goodType goodType;

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

    public com.jm.marketplace.models.goodCategory getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(com.jm.marketplace.models.goodCategory goodCategory) {
        this.goodCategory = goodCategory;
    }

    public com.jm.marketplace.models.goodSubcategory getGoodSubcategory() {
        return goodSubcategory;
    }

    public void setGoodSubcategory(com.jm.marketplace.models.goodSubcategory goodSubcategory) {
        this.goodSubcategory = goodSubcategory;
    }

    public com.jm.marketplace.models.goodType getGoodType() {
        return goodType;
    }

    public void setGoodType(com.jm.marketplace.models.goodType goodType) {
        this.goodType = goodType;
    }
}
