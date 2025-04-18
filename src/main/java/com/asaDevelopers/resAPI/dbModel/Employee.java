package com.asaDevelopers.resAPI.dbModel;

import com.asaDevelopers.resAPI.model.EmployeeRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name" )
    private String name;

    @Column(name = "cnic" )
    private Integer cnic;

    @Enumerated(EnumType.STRING )
    @Column(name = "role" )
    private EmployeeRoles role;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "is_active" )
    private boolean isActive;

    @Column(name = "is_uploaded" )
    private Boolean isUploaded;
}
