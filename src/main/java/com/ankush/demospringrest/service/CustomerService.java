package com.ankush.demospringrest.service;

import com.ankush.demospringrest.dto.CustomerDTO;
import com.ankush.demospringrest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String createCustomer(CustomerDTO customerDTO){
        customerRepository.createCustomer(customerDTO);
        return "Customer with "+customerDTO.getPhoneNo()+" added successfully";
    }

    public List<CustomerDTO> fetchCustomer(){
        return customerRepository.fetchCustomer();
    }
}
