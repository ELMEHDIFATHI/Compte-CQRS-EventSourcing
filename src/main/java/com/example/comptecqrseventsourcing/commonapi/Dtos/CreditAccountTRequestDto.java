package com.example.comptecqrseventsourcing.commonapi.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreditAccountTRequestDto {

    private String AccountId;

    private double amount;
    private String currency;


}
