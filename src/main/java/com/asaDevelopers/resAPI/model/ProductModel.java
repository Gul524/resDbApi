package com.asaDevelopers.resAPI.model;

import com.asaDevelopers.resAPI.dbModel.Flavour;
import com.asaDevelopers.resAPI.dbModel.Product;
import com.asaDevelopers.resAPI.dbModel.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProductModel {
    Product prod;
    List<Size> sizes;
    List<Flavour> flavours;
    List<DealModels> deals ;
}
