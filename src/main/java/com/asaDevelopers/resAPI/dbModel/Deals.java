package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Product_id" )
    private Integer productId;

    @Column(name = "deal_name")
    private String productName;

    @Column(name = "minimum_selection")
    private Boolean minimunSelection;

    @Column(name = "maximum_selection")
    private Boolean maximumSelection;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "deal_id" , referencedColumnName = "id")
    private List<DealItems> dealItems ;
}
