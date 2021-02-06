package com.jm.marketplace.model.goods;

import com.jm.marketplace.model.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="goodSubcategory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}
