package com.asadevelopers.resDbApi.dbModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Flavour")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flavour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "flavour_id")
    private Integer flavourId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "branch" )
    private Integer branchId;

    @Column(name = "has_all_branches" )
    private boolean hasAllBranches;

    @Column(name = "is_uploaded")
    private Boolean isUploaded;
}
