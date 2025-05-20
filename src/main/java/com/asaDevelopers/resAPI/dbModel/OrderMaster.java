package com.asaDevelopers.resAPI.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
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

    //tabName
    @Column(name = "order_number")
    private String orderNumber;

    //
    @Column(name = "customer_id")
    private Integer customerId;

    //time
    @Column(name = "order_time")
    private String orderTime;

    //date
    @Column(name = "order_date")
    private String orderDate;

    //grandTotal
    @Column(name = "total_amount")
    private Integer totalAmount;


    //tax
    @Column(name = "tax_amount")
    private Integer taxAmount;

    //subtotal
    @Column(name = "amount_without_tax")
    private Integer amountWithoutTax;



//     One OrderMaster has many OrderDetails
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_Master_Id" , referencedColumnName = "id")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_Master_Id" , referencedColumnName = "id")
    private List<OrderDealDetail> orderDealDetails = new ArrayList<>();
}
