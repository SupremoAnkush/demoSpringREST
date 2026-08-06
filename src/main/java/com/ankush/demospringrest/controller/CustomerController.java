package com.ankush.demospringrest.controller;

import com.ankush.demospringrest.dto.CustomerDTO;
import com.ankush.demospringrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = "application/json")
    public List<CustomerDTO> fetchCustomer(){
//        This method will fetch customers and return the same .
        return customerService.fetchCustomer();
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO){

//        This method will persist details of customer
//        Receive the response after persisting the customer details.
        String response = customerService.createCustomer(customerDTO);
//        Returns the response with response body and status code.
        return ResponseEntity.ok(response);
    }
    @PutMapping(value = "/{phoneNo}", consumes = "application/json")
    public String updateCustomer(@PathVariable(name = "phoneNo") long phoneNo, @RequestBody CustomerDTO customerDTO){
//        This method will update details of existing customer.
        return customerService.updateCustomer(phoneNo, customerDTO);
    }
    @DeleteMapping(value = "/{phoneNo}")
    public String deleteCustomer(@PathVariable("phoneNo") long phoneNo){
//        This method will delete a customer.
        return customerService.deleteCustomer(phoneNo);
    }
}
