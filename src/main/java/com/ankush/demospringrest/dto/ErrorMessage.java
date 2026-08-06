package com.ankush.demospringrest.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ErrorMessage {

    private Integer errorCode;
    private String message;

}
