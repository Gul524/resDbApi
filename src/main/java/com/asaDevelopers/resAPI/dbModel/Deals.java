package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Deals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "deal_name")
    private String dealName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;
}
