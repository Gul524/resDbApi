package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderDetail", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_size")
    private String productSize;


    @Column(name = "product_flavor")
    private String productFlavor;

    //quantity
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Integer price;


}
