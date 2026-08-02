package com.ankush.demospringrest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping
    public String fetchCustomer(){
//        This method will fetch customers and return the same .
        return "customer fetched successfully" ;
    }
    @PostMapping
    public String createCustomer(){
//        This method will persist details of customer.
        return "customer added successfully" ;
    }
    @PutMapping
    public String updateCustomer(){
//        This method will update details of existing customer.
        return "customer details updated successfully" ;
    }
    @DeleteMapping
    public String deleteCustomer(){
//        This method will delete a customer.
        return "customer details deleted successfully" ;
    }
}
