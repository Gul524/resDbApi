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

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_size")
    private String itemSize;

    @Column(name = "item_flavor")
    private String itemFlavor;

    @Column(name = "quantity")
    private Integer quantity;


}