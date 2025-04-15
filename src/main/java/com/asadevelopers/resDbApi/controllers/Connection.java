package com.asadevelopers.resDbApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connection")
public class Connection {
    @GetMapping("/check")
    public String checkConnection(){
        return "Ok , Connection with Api working Properly";
    }
}
