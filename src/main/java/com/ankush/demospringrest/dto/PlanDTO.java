package com.ankush.demospringrest.dto;


import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Setter
@Getter
//@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
@ToString
@XmlRootElement
public class PlanDTO {
    Integer planId;
    String planName;
    Integer nationalRate;
    Integer localRate;
}
