package com.jm.marketplace.model.goods;

import com.jm.marketplace.model.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="good_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "good_subcategory_id", nullable=false)
    private GoodSubcategory goodSubcategory;

}
