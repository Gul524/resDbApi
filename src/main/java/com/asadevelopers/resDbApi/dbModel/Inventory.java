package com.asadevelopers.resDbApi.dbModel;

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

    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "has_all_branches" )
    private boolean hasAllBranches;

    @Column(name = "available_quantity")
    private Double availableQuantity;

    @Column(name = "is_uploaded")
    private Boolean isUploaded;
}
