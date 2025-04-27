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

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "size_name")
    private String sizeName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "flavour_name")
    private String flavourName;
}
