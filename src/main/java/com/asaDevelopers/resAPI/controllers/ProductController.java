package com.asaDevelopers.resAPI.controllers;

import com.asaDevelopers.resAPI.dbModel.*;
import com.asaDevelopers.resAPI.model.ApiResponse;
import com.asaDevelopers.resAPI.model.Order;
import com.asaDevelopers.resAPI.services.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branchApi/products")
public class ProductController {

    // Categories
    @Autowired private CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse<Category>> addCategory(@RequestBody Iterable<Category> c) { return categoryService.save(c);  }

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<Category>>> Categories() { return categoryService.getAll();  }

    @GetMapping("/categoryById/{id}")
    public ResponseEntity<ApiResponse<List<Category>>> getCategorybyId(@PathVariable Integer id) { return categoryService.getAllByBranchId(id);  }

    @PostMapping("/deleteCategory/{id}")
    public ResponseEntity<ApiResponse<String>> del_category(@PathVariable Integer id) {
        return productService.delete(id);
    }

    // Products
    @Autowired
    private ProductService productService;
    @PostMapping("/addProducts")
    public ResponseEntity<ApiResponse<Product>> getProductService(@RequestBody Iterable<Product> p) {
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

    // Sizes
    @Autowired private SizeService ss;

    @GetMapping("sizes")
    public ResponseEntity<ApiResponse<List<Size>>> getSizes(){
        return ss.getAll();
    }

    @GetMapping("sizesByBranchId")
    public ResponseEntity<ApiResponse<List<Size>>> getSizes(Integer id){
        return ss.getAllByBranchId(id);
    }

    @PostMapping("/addSize")
    public ResponseEntity<ApiResponse<Size>> saveSize(@RequestBody Iterable<Size> s){
        return  ss.save(s);
    }

    // Flavour
    @Autowired private FlavourService fs;

    @GetMapping("Flavours")
    public ResponseEntity<ApiResponse<List<Flavour>>> getFlavours(){
        return fs.getAll();
    }

    @GetMapping("flavoursByBranchId")
    public ResponseEntity<ApiResponse<List<Flavour>>> getFlavoursbyID(Integer id){
        return fs.getAllByBranchId(id);
    }

    @PostMapping("/addFlavour")
    public ResponseEntity<ApiResponse<Flavour>> save_size(@RequestBody Iterable<Flavour> f){
        return  fs.save(f);
    }
//    // orderHistoryMaintaince
//    @Autowired
//    OrderMasterService oms;
//    @Autowired OrderDetailService ods;
//    @PostMapping("/placeOrder")
//    public ResponseEntity<ApiResponse<String>> placeOrder(@RequestBody Order o){
//
//
//    }


}
