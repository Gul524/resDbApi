package com.asaDevelopers.resAPI.services;

import com.asaDevelopers.resAPI.dbModel.Category;
import com.asaDevelopers.resAPI.dbModel.Product;
import com.asaDevelopers.resAPI.model.AllDeleteModel;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.model.priceModel;
import com.asaDevelopers.resAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired private ProductRepository repository;

    public ResponseEntity<ApiResponse<List<Product>>> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" , repository.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage(), e.getCause().toString() , null));
        }
    }

    public ResponseEntity<ApiResponse<Product>> updatePriceById(Integer id , priceModel pm ) {
        try {
            final Optional<Product> oProduct = repository.findById(id);
            if(oProduct.isPresent()){
                Product product = oProduct.get();
                product.setPrimaryPrice(pm.getPrimary_price());
                product.setSecondaryPrice(pm.getSecondary_price());
                product.setDiscountPercent(pm.getDiscount_percent());
                repository.save(product);
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

    public ResponseEntity<ApiResponse<Product>> save(Iterable<Product> entity) {
        try {
            repository.saveAll(entity);
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

    public ResponseEntity<ApiResponse<List<Product>>> getAllByBranchId(Integer id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true , "Successful" , "" ,repository.findByBranchId(id)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(false , e.getMessage() , e.getCause().toString() ,null));
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
