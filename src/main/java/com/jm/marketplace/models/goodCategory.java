package com.jm.marketplace.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="good_category")
public class goodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "goodCategory")
    private Set<goodSubcategory> goodSubcategory;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "goodCategory")
    private Set<advertisement> advertisement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<goodSubcategory> goodSubcategory() {
        return goodSubcategory;
    }

    public void goodSubcategory(Set<goodSubcategory> goodSubcategory) {
        this.goodSubcategory = goodSubcategory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<com.jm.marketplace.models.goodSubcategory> getGoodSubcategory() {
        return goodSubcategory;
    }

    public void setGoodSubcategory(Set<com.jm.marketplace.models.goodSubcategory> goodSubcategory) {
        this.goodSubcategory = goodSubcategory;
    }

    public Set<com.jm.marketplace.models.advertisement> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Set<com.jm.marketplace.models.advertisement> advertisement) {
        this.advertisement = advertisement;
    }
}
