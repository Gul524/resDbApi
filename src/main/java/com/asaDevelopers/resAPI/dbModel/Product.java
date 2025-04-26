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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private List<Size> sizes ;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "product_id" , referencedColumnName = "id")
    private List<Flavour> flavors ;

}
