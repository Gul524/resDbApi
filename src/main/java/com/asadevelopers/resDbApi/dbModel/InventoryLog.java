package com.asadevelopers.resDbApi.dbModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "InventoryLog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "InventoryId")
    private Integer inventoryId;

    @Column(name = "EmployeeId")
    private Integer employeeId;

    @Column(name = "Quantity")
    private Double quantity;

    @Column(name = "Log")
    private String log;

    @Column(name = "isAdded")
    private Boolean isAdded;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "IsUploaded")
    private Boolean isUploaded;
}

