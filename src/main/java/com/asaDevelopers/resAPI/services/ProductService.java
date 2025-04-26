package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Deals;
import com.asaDevelopers.resAPI.dbModel.Product;
import com.asaDevelopers.resAPI.model.AllDeleteModel;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.model.ProductModel;
import com.asaDevelopers.resAPI.model.priceModel;
import com.asaDevelopers.resAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired private ProductRepository repository;
    @Autowired private DealRepository dealRepo;
    @Autowired private DealItemsRepository dealItemsRepo;
    @Autowired private SizeRepository sizesRepo;
    @Autowired private FlavourRepository flavourRepo;
    @Autowired private CategoryRepository categoryRepo;

    public ResponseEntity<ApiResponse<List<Product>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" , repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage(), e.getCause().toString() , null));
        }
    }

    public ResponseEntity<ApiResponse<Product>> updatePoduct(Integer id , ProductModel product ) {
        try {
            final Optional<Product> oProduct = repository.findById(id);
            if(oProduct.isPresent()){
                repository.delete(oProduct.get());
                Optional<Category> oc = categoryRepo.findById(product.getCategoryId());
                if(oc.isPresent()){
                    Product p = new Product();
                    p.setProductName(product.getProductName());
                    p.setCategory(oc.get());
                    p.setSizes(product.getSizes());
                    p.setFlavors(product.getFlavors());
                    p.setPrice(product.getPrice());
                    repository.save(p);
                }
            }
            return ResponseEntity.ok(new ApiResponse<>(true , "Product Price Updated Successfully" , "" , null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(true ,e.getMessage() ,e.getCause().toString(), null));
        }
    }

    public ResponseEntity<ApiResponse<Optional<Product>>> getById(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" , repository.findById(id) ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() , null));
        }
    }

    public ResponseEntity<ApiResponse<Product>> save(Iterable<ProductModel> entity) {
        List<Product> lp = new ArrayList<>();
        try {
            for(ProductModel pm : entity){
                Optional<Category> oc = categoryRepo.findById(pm.getCategoryId());
                if(oc.isPresent()){
                    Product p = new Product();
                    p.setProductName(pm.getProductName());
                    p.setCategory(oc.get());
                    p.setSizes(pm.getSizes());
                    p.setFlavors(pm.getFlavors());
                    p.setPrice(pm.getPrice());
                    lp.add(p);
                }
            }
            repository.saveAll(lp);
            return ResponseEntity.ok(new ApiResponse<>(true , "Product Added Successfully " , "", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() , null));
        }
    }

    public ResponseEntity<ApiResponse<String>> delete(Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>(true , "Product Deleted Successfully " , "", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() , null));
        }
    }


    public ResponseEntity<ApiResponse<String>> deleteAll() {
        try {
            repository.deleteAll();
            return ResponseEntity.ok(new ApiResponse<>(true , "Product Deleted Successfully " , "", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() , null));
        }
    }
}
