package com.jm.marketplace.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="good_type")
public class GoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_subcategory_id", nullable=false)
    private GoodSubcategory goodSubcategory;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="goodType")
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

    public GoodSubcategory getGoodSubcategory() {
        return goodSubcategory;
    }

    public void setGoodSubcategory(GoodSubcategory goodSubcategory) {
        this.goodSubcategory = goodSubcategory;
    }

    public Set<Advertisement> getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Set<Advertisement> advertisement) {
        this.advertisement = advertisement;
    }

}
