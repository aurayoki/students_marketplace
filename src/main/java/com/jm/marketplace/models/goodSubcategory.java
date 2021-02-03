package com.jm.marketplace.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="goodSubcategory")
public class goodSubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_category_id", nullable = false)
    private goodCategory goodCategory;

    public com.jm.marketplace.models.goodCategory getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(com.jm.marketplace.models.goodCategory goodCategory) {
        this.goodCategory = goodCategory;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy="goodSubcategory")
    private Set<goodType> goodTypeSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="goodSubcategory")
    private Set<advertisement> advertisement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<goodType> getGoodTypeSet() {
        return goodTypeSet;
    }

    public void setGoodTypeSet(Set<goodType> goodTypeSet) {
        this.goodTypeSet = goodTypeSet;
    }

    public Set<com.jm.marketplace.models.advertisement> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Set<com.jm.marketplace.models.advertisement> advertisement) {
        this.advertisement = advertisement;
    }
}
