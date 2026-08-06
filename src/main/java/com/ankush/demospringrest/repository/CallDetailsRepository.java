package com.ankush.demospringrest.repository;

import com.ankush.demospringrest.dto.CallDetailsDTO;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CallDetailsRepository {

    List<CallDetailsDTO> callDetails = new ArrayList<>();
//    CallDetailsDTO callDetailsDTO = null;
//    CallDetailsDTO callDetailsDTO1 = null;
//    LocalDate calledOn = null;

//    Populating CallDetailsDTO
    @PostConstruct
    public void populatecalledOn(){

        CallDetailsDTO callDetailsDTO = new CallDetailsDTO();
        CallDetailsDTO callDetailsDTO1 = new CallDetailsDTO();
        LocalDate calledOn = LocalDate.now();
        callDetailsDTO.setCalledBy(8870106465l);
        callDetailsDTO.setCalledTo(9930508495l);
        callDetailsDTO.setCalledOn(calledOn);
        callDetailsDTO.setDuration(3);
        callDetailsDTO1.setCalledBy(8870106465l);
        callDetailsDTO1.setCalledTo(9930508495l);
        callDetailsDTO1.setCalledOn(calledOn);
        callDetailsDTO1.setDuration(5);
        callDetails.add(callDetailsDTO);
        callDetails.add(callDetailsDTO1);
    }

//    fetch call details based on calledBy and calledOn attributes of callDetailsDTO
    public List<CallDetailsDTO> fetchCallDetails(long calledBy, LocalDate calledOn){
        List<CallDetailsDTO> callDetailsResultSet = new ArrayList<>();
        for (CallDetailsDTO callDetail : callDetails){
            if (callDetail.getCalledBy() == calledBy && callDetail.getCalledOn().equals(calledOn))
                callDetailsResultSet.add(callDetail);
        }
        return callDetailsResultSet;
    }
}
