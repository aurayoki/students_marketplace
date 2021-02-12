package com.jm.marketplace.model;

import com.jm.marketplace.model.goods.GoodsCategory;
import com.jm.marketplace.model.goods.GoodsSubcategory;
import com.jm.marketplace.model.goods.GoodsType;
import com.jm.marketplace.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "advertisement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "expired")
    private Boolean expired;

    @Column(name = "publication_date")
    private LocalDate publication_date;

    @Column(name = "banned")
    private Boolean banned;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_category_id", nullable = false)
    private GoodsCategory goodsCategory;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_subcategory_id", nullable = false)
    private GoodsSubcategory goodsSubcategory;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_type_id", nullable = false)
    private GoodsType goodsType;

}
