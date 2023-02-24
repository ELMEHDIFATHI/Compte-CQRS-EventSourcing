package com.example.comptecqrseventsourcing.commonapi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateAccountTRequestDto {
    private double initialBalance;
    private String currency;

}
