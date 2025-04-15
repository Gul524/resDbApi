package com.asadevelopers.resDbApi.model;

import com.asadevelopers.resDbApi.dbModel.OrderDetail;
import com.asadevelopers.resDbApi.dbModel.OrderMaster;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    
    OrderMaster orderMaster;
    List<OrderDetail>  orderDetails;
}
