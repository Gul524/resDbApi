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
@RequestMapping("/resApi/products")
public class ProductController {

    // Categories
    @Autowired private CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse<Category>> addCategory(@RequestBody Iterable<Category> c) { return categoryService.save(c);  }

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<Category>>> Categories() { return categoryService.getAll();  }

    @PostMapping("/deleteCategory/{id}")
    public ResponseEntity<ApiResponse<String>> del_category(@PathVariable Integer id) {
        return categoryService.delete(id);
    }

    @PostMapping("/updateCategory/{id}/{name}")
    public ResponseEntity<ApiResponse<String>> update_category(@PathVariable Integer id , @PathVariable String name) {
        return categoryService.update(id,name);
    }

    // Products
    @Autowired
    private ProductService productService;
    @PostMapping("/addProducts")
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

//    // Sizes
//    @Autowired private SizeService ss;
//
//    @GetMapping("sizes")
//    public ResponseEntity<ApiResponse<List<Size>>> getSizes(){
//        return ss.getAll();
//    }
//
//
//
//    @PostMapping("/addSize")
//    public ResponseEntity<ApiResponse<Size>> saveSize(@RequestBody Iterable<Size> s){
//        return  ss.save(s);
//    }
//
//    // Flavour
//    @Autowired private FlavourService fs;
//
//    @GetMapping("Flavours")
//    public ResponseEntity<ApiResponse<List<Flavour>>> getFlavours(){
//        return fs.getAll();
//    }
//
//
//    @PostMapping("/addFlavour")
//    public ResponseEntity<ApiResponse<Flavour>> save_size(@RequestBody Iterable<Flavour> f){
//        return  fs.save(f);
//    }


//    orderHistoryMaintaince
    @Autowired
    OrderMasterService oms;
    @PostMapping("/placeOrder")
    public ResponseEntity<ApiResponse<String>> placeOrder(@RequestBody Iterable<OrderMaster> o){
       return oms.save(o);
    }

    @GetMapping("/OrdersByBranch/{id}")
    public ResponseEntity<ApiResponse<List<OrderMaster>>> branchOrder(@PathVariable Integer id){
        return oms.getAllByBranchId(id);
    }

    @GetMapping("/OrdersByPhone/{id}")
    public ResponseEntity<ApiResponse<List<OrderMaster>>> customerOrder(@PathVariable Integer phone){
        return oms.getAllByBranchId(phone);
    }

    @PostMapping("/OrderStatusUpdate/{id}")
    public ResponseEntity<ApiResponse<String>> orderStatus(@RequestBody StatusModel sm){
        return oms.status(sm.getId() , sm.getStatus());
    }


}
