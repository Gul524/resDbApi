package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OrderMaster", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_time")
    private String orderTime;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name = "tax_amount")
    private Integer taxAmount;

    @Column(name = "amount_without_tax")
    private Integer amountWithoutTax;

    @Column(name = "customer_phone")
    private Integer customerPhone;

    @Column(name = "waiter_id")
    private Integer waiterId;

    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "cash_Counter")
    private Integer cashCounterNo;

    @Column(name = "special_instruction")
    private String specialInstruction;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "is_uploaded")
    private Boolean isUploaded;


//     One OrderMaster has many OrderDetails
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_Master_Id" , referencedColumnName = "id")
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
