package com.asaDevelopers.resAPI.controllers;

import com.asaDevelopers.resAPI.dbModel.*;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.model.ProductModel;
import com.asaDevelopers.resAPI.model.StatusModel;
import com.asaDevelopers.resAPI.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resApi/products/")
public class ProductController {

    // Categories
    @Autowired private CategoryService categoryService;
    @PostMapping("addCategory")
    public ResponseEntity<ApiResponse<Category>> addCategory(@RequestBody Iterable<Category> c) { return categoryService.save(c);  }

    @GetMapping("categories")
    public ResponseEntity<ApiResponse<List<Category>>> Categories() { return categoryService.getAll();  }

    @PostMapping("deleteCategory/{id}")
    public ResponseEntity<ApiResponse<String>> del_category(@PathVariable Integer id) {
        return categoryService.delete(id);
    }

    @PostMapping("updateCategory/{id}/{name}")
    public ResponseEntity<ApiResponse<String>> update_category(@PathVariable Integer id , @PathVariable String name) {
        return categoryService.update(id,name);
    }

    // Products
    @Autowired
    private ProductService productService;
    @PostMapping("addProducts")
    public ResponseEntity<ApiResponse<Product>> getProductService(@RequestBody Iterable<ProductModel> p) {
        return productService.save(p);
    }

    @PostMapping("/deleteProducts/{id}")
    public ResponseEntity<ApiResponse<String>> del_product(@PathVariable Integer id) {
        return productService.delete(id);
    }

    @GetMapping("products")
    public ResponseEntity<ApiResponse<List<Product>>> getProduct(){
        return productService.getAll();
    }

    @PostMapping("updateProducts/{id}")
    public ResponseEntity<ApiResponse<Product>>  del_product(@PathVariable Integer id , @RequestBody ProductModel pm) {
        return productService.updateProduct(id ,pm);
    }



//    orderHistoryMaintance
    @Autowired
    OrderMasterService oms;

    @GetMapping("orders")
    public ResponseEntity<ApiResponse<List<OrderMaster>>> order(){
        return oms.getAll();
    }

    @PostMapping("placeOrder")
    public ResponseEntity<ApiResponse<String>> placeOrder(@RequestBody OrderMaster o){
       return oms.save(o);
    }

    @PostMapping("OrderStatusUpdate/{id}")
    public ResponseEntity<ApiResponse<String>> orderStatus(@RequestBody StatusModel sm){
        return oms.status(sm.getId() , sm.getStatus());
    }


}
