package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Table", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "table_id")
    private Integer tableId;

    @Column(name = "table_number", nullable = false)
    private Integer tableNumber;

    @Column(name = "table_size", nullable = false)
    private Integer tableSize;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "branch" )
    private Integer branchId;
}
