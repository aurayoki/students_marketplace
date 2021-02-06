package com.jm.marketplace.model.goods;

import com.jm.marketplace.model.Advertisement;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="good_category")
public class GoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "goodCategory")
    private Set<GoodSubcategory> goodSubcategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GoodSubcategory> goodSubcategory() {
        return goodSubcategory;
    }

    public void goodSubcategory(Set<GoodSubcategory> goodSubcategory) {
        this.goodSubcategory = goodSubcategory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<GoodSubcategory> getGoodSubcategory() {
        return goodSubcategory;
    }

    public void setGoodSubcategory(Set<GoodSubcategory> goodSubcategory) {
        this.goodSubcategory = goodSubcategory;
    }

}
