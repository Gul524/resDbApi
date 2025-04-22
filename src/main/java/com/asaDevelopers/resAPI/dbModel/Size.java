package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Sizes", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "deal_item_id")
    private Integer DealItemId;

    @Column(name = "Product_id" )
    private Integer productId;

    @Column(name = "Price")
    private Integer price;


}
