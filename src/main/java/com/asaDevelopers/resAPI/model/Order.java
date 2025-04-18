package com.asaDevelopers.resAPI.model;

import com.asaDevelopers.resAPI.dbModel.OrderDetail;
import com.asaDevelopers.resAPI.dbModel.OrderMaster;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    
    OrderMaster orderMaster;
    List<OrderDetail>  orderDetails;
}
