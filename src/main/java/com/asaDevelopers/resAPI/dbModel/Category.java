package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "category_id" )
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "has_all_branches" )
    private boolean hasAllBranches;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_uploaded")
    private Boolean isUploaded;
}
