package com.ankush.demospringrest.repository;

import com.ankush.demospringrest.dto.CustomerDTO;
import com.ankush.demospringrest.dto.FriendFamilyDTO;
import com.ankush.demospringrest.dto.PlanDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
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
    public String createCustomer(CustomerDTO customerDTO){
        customers.add(customerDTO);
        return "Customer with "+customerDTO.getPhoneNo()+" added successfully";
    }

//    Returns a list of customers
    public List<CustomerDTO> fetchCustomer(){
        return  customers;
    }

//    Delete customers
    public String deleteCustomer(long phoneNo) {
        String response = "Customer of : " + phoneNo + " \t does not exist";
        for (CustomerDTO customer : customers) {
            if (customer.getPhoneNo() == phoneNo){
            customers.remove(customer);
            response = customer.getName() + " of phone Number " + customer.getPhoneNo() + " \tgot deleted successfully";
            break;
        }
        }
        return response;
    }


//    Updates customers
    public String updateCustomer(long phoneNumber, CustomerDTO customerDTO){
        String response = "Customer of : "+phoneNumber+" \tdoes not exist";
        for (CustomerDTO customer : customers) {
            if (customer.getPhoneNo() == phoneNumber){
                if (customerDTO.getName()!=null)
                    customer.setName(customerDTO.getName());
                if (customerDTO.getAddress()!=null)
                    customer.setAddress(customerDTO.getAddress());
                if (customerDTO.getPassword()!=null)
                    customer.setPassword(customerDTO.getPassword());

                customers.set(customers.indexOf(customer), customer);
                response = "Customer of Phone Number "+customer.getPhoneNo()+"\t got updated successfully";
                break;

            }
        }
        return response;

    }

}
