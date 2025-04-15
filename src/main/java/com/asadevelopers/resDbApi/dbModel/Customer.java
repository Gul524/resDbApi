package com.asadevelopers.resDbApi.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.UniqueKey;

@Entity
@Table(name = "Customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "phone" , unique = true , nullable = false)
    private String phone;

    @Column(name = "available_points")
    private Integer availablePoints;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "is_uploaded")
    private Boolean isUploaded;
}
