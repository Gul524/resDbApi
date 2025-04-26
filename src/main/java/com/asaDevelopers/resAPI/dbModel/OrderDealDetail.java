package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderDealDetail", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDealDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "order_master_id")
    private Integer orderMasterId;

    @Column(name = "deal_name")
    private String dealName;

    @Column(name = "deal_size")
    private String dealSize;

    @Column(name = "product_flavour")
    private String productFlavour;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "branch_id")
    private Integer branchId;

}