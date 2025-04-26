package com.asaDevelopers.resAPI.dbModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Flavor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flavour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private  String name;

}
