package com.ankush.demospringrest.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class CustomerDTO {

    Long phoneNo;
    String name;
    String email;
    int age;
    char gender;
    List<FriendFamilyDTO> friendFamily;
    String password;
    String address;
    PlanDTO currentPlan;

}
