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

    public String updateCustomer(long phoneNo, CustomerDTO customerDTO) {
        String response = "Customer of: "+phoneNo+" does not exist";

        for(CustomerDTO customer : customerRepository.fetchCustomer()){
            if (customer.getPhoneNo() != null && customer.getPhoneNo().equals(phoneNo)){

                if(customerDTO.getName() != null)
                    customer.setName(customerDTO.getName());

                if(customerDTO.getAddress() != null)
                    customer.setAddress(customerDTO.getAddress());

                if(customerDTO.getPassword() != null)
                    customer.setPassword(customerDTO.getPassword());

                response = "Customer of: " + phoneNo + " got updated successfully";
                break;
            }
        }
        return response;
    }

    public String deleteCustomer(long phoneNo) {
        String response = "Customer of: " + phoneNo + " does not exist";

        for (CustomerDTO customer : customerRepository.fetchCustomer()) {
            if (customer.getPhoneNo() == phoneNo) {
                customerRepository.deleteCustomer(customer);
                response = customer.getName() + " of phone number " + customer.getPhoneNo() + " got deleted successfully";
                break;
            }
        }
        return response;
    }
}

