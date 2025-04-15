package com.asadevelopers.resDbApi.model;

import lombok.Data;

@Data
public class priceModel {
    Integer product_id ;
    Integer primary_price;
    Integer secondary_price;
    Integer discount_percent;
}
