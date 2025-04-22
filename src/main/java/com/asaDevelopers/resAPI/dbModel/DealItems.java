package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "DealItems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "deal_id")
    private Integer  dealId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private Integer price;


    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "deal_item_id" , referencedColumnName = "id")
    private List<Flavour> flavours ;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "deal_item_id" , referencedColumnName = "id")
    private List<Deals> deals ;

}
