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

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Integer price;


    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "order_deal_id" , referencedColumnName = "id")
    private List<OrderDealItemDetail> orderDealItems ;

}