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

    @Column(name = "price")
    private Integer price;

}
