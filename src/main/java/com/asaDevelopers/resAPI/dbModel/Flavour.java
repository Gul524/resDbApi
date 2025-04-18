package com.asaDevelopers.resAPI.dbModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Flavour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flavour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name")
    private  String name;

    @Column(name = "deal_item_id")
    private Integer dealItemId;

    @Column(name = "Price", nullable = false)
    private Integer price;
}
