package com.asadevelopers.resDbApi.controllers;

import com.asadevelopers.resDbApi.model.ApiResponse;
import com.asadevelopers.resDbApi.services.CategoryService;
import com.asadevelopers.resDbApi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("branchAPi/delete")
public class AllDeleteController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/products")
    public ResponseEntity<ApiResponse<String>> del_p(@RequestHeader ("DeleteId") Integer deleteId){
        if(deleteId.equals(343183)){
           return productService.deleteAll();
    }
       return ResponseEntity.ok(new ApiResponse<>(true , "Invalid DeleteId , " , "" , null));

    }

}
