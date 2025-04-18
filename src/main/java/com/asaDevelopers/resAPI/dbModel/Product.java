package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "primary_price")
    private Integer primaryPrice;

    @Column(name = "secondary_price")
    private Integer secondaryPrice;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "is_deal_product")
    private Boolean isDealProduct;

    @Column(name = "is_fixed_deal")
    private Boolean isFixedDeal;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private List<Size> sizes ;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private List<Flavour> flavours ;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private List<Deals> deals ;


}
