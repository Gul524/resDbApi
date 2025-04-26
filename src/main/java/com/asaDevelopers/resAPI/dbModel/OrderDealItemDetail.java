package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderDealItemDetail", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDealItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "deal_item_name")
    private String dealItemName;

    @Column(name = "deal_item_size")
    private String dealSize;

    @Column(name = "deal_item_flavour")
    private String productFlavour;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "branch_id")
    private Integer branchId;

}