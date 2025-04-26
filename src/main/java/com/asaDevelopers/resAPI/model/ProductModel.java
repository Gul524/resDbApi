package com.asaDevelopers.resAPI.model;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Flavour;
import com.asaDevelopers.resAPI.dbModel.Product;
import com.asaDevelopers.resAPI.dbModel.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ProductModel {
    private Integer categoryId;
    private String productName;
    private Integer price;
    private List<Size> sizes ;
    private List<Flavour> flavors ;
}
