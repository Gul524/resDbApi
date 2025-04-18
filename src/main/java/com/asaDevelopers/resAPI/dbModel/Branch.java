package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Branch")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "name")
    private String name;

    @Column(name = "start_timing" )
    private String startTiming;

    @Column(name = "end_time" )
    private String endTime;

    @Column(name = "phone" )
    private String phone;

    @Column(name = "uploaded")
    private Boolean uploaded;
}
