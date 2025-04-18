package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "primary_price")
    private Integer primaryPrice;

    @Column(name = "secondary_price")
    private Integer secondaryPrice;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "size_id")
    private Integer sizeId;

    @Column(name = "flavour_id")
    private Integer flavourId;

    @Column(name = "is_uploaded")
    private Boolean isUploaded;

    @Column(name = "is_deal_product")
    private Boolean isDealProduct;

    @Column(name = "is_deal_item")
    private Boolean isDealItem;

    @Column(name = "is_fixed_deal")
    private Boolean isFixedDeal;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "has_all_branches" )
    private boolean hasAllBranches;

    @Column(name = "is_active")
    private Boolean isActive;
}
