package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DiningTable", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "table_number")
    private Integer tableNumber;

    @Column(name = "table_size" )
    private Integer tableSize;

    @Column(name = "status")
    private String status;

    @Column(name = "branch" )
    private Integer branchId;
}
