package com.asadevelopers.resDbApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Product {
    @GetMapping("/product")
    public String addProduct(){
        return "Product added";
    }
}
