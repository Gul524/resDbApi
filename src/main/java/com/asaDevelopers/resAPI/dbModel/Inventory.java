package com.asaDevelopers.resAPI.dbModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "Quantity")
    private Double quantity;

    @Column(name = "available_quantity")
    private Double availableQuantity;

}
