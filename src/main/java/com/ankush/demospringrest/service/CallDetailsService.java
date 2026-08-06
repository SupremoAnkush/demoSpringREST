package com.ankush.demospringrest.service;

import com.ankush.demospringrest.dto.CallDetailsDTO;
import com.ankush.demospringrest.repository.CallDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class CallDetailsService {
    @Autowired
    private CallDetailsRepository callDetailsRepository;
    public List<CallDetailsDTO> fetchCallDetails(long calledBy, LocalDate calledOn) {
        return callDetailsRepository.fetchCallDetails(calledBy, calledOn);
    }
}
