package com.ankush.demospringrest.repository;

import com.ankush.demospringrest.dto.CustomerDTO;
import com.ankush.demospringrest.dto.FriendFamilyDTO;
import com.ankush.demospringrest.dto.PlanDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private List<CustomerDTO> customers = new ArrayList<>();
//   This is equivalent to constructor. Here, populates the DTOs in hard coded way
    @PostConstruct
    public void initializer(){
        CustomerDTO customerDTO = new CustomerDTO();
        PlanDTO planDTO = new PlanDTO();

        planDTO.setPlanId(1);
        planDTO.setPlanName("Simple");
        planDTO.setLocalRate(3);
        planDTO.setNationalRate(5);

        customerDTO.setAddress("Chennai");
        customerDTO.setAge(18);
        customerDTO.setCurrentPlan(planDTO);
        customerDTO.setGender('M');
        customerDTO.setName("Jack");
        customerDTO.setEmail("Jack@gmail.com");
        customerDTO.setPassword("ABC@123");
        customerDTO.setPhoneNo(9951212221L);

        List<FriendFamilyDTO> friendAndFamily = new ArrayList<>();
        friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(), 800000145L));
        friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(), 700000145L));

        customerDTO.setFriendFamily(friendAndFamily);

        customers = new ArrayList<>();
        customers.add(customerDTO);
    }

//    Adds the received Customer object to customer list
    public void createCustomer(CustomerDTO customerDTO){
        customers.add(customerDTO);
    }

//    Returns a list of customers
    public List<CustomerDTO> fetchCustomer(){
        return  customers;
    }

    public void deleteCustomer(CustomerDTO customer) {
        customers.remove(customer);
    }
}
