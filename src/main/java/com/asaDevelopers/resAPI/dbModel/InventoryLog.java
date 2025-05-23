package com.asaDevelopers.resAPI.dbModel;

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

    @Column(name = "Quantity")
    private Double quantity;

    @Column(name = "Log")
    private String log;

}

