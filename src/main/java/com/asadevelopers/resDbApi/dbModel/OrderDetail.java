package com.asadevelopers.resDbApi.dbModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderDetail", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @Column(name = "order_master_id")
    private Integer orderMasterId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_size")
    private String productSize;

    @Column(name = "product_flavour")
    private String productFlavour;

    @Column(name = "is_deal_product")
    private Boolean isDealProduct;

    @Column(name = "is_deal_item")
    private Boolean isDealItem;

    @Column(name = "unique_deal_id")
    private Integer uniqueDealId;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "amount_with_tax")
    private Integer amountWithTax;

    @Column(name = "amount_without_tax")
    private Integer amountWithoutTax;

    @Column(name = "tax_percent")
    private Integer taxPercent;

    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "is_uploaded")
    private Boolean isUploaded;
}
