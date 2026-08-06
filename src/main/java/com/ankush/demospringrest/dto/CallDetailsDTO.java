package com.ankush.demospringrest.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class CallDetailsDTO {

    long calledBy;
    long calledTo;
    LocalDate calledOn;
    Integer duration;
}
