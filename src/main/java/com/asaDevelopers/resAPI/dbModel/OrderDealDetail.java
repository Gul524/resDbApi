package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name = "deal_name")
    private String dealName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Integer price;

}