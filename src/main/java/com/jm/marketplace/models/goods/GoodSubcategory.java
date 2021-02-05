package com.jm.marketplace.models.goods;

import com.jm.marketplace.models.Advertisement;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="goodSubcategory")
public class GoodSubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_category_id", nullable = false)
    private GoodCategory goodCategory;

    public GoodCategory getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(GoodCategory goodCategory) {
        this.goodCategory = goodCategory;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy="goodSubcategory")
    private Set<GoodType> goodTypeSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="goodSubcategory")
    private Set<Advertisement> advertisement;

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

    public Set<GoodType> getGoodTypeSet() {
        return goodTypeSet;
    }

    public void setGoodTypeSet(Set<GoodType> goodTypeSet) {
        this.goodTypeSet = goodTypeSet;
    }

    public Set<Advertisement> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Set<Advertisement> advertisement) {
        this.advertisement = advertisement;
    }
}
