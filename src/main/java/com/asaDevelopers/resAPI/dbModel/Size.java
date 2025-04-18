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

    @Column(name = "ProductId", nullable = false)
    private Integer productId;

    @Column(name = "Price", nullable = false)
    private Integer price;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "has_all_branches" )
    private boolean hasAllBranches;

    @Column(name = "isUploaded", nullable = false)
    private Boolean isUploaded;
}
