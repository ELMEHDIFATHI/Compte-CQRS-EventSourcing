package com.example.comptecqrseventsourcing.commonapi.events;

import lombok.Getter;

public class AccountDebitedEvent extends BaseEvent<String>{


    @Getter
    private double amount ;
    @Getter
    private String currency;

    public AccountDebitedEvent(String AccountId, double amount, String currency) {
        super(AccountId);
        this.amount = amount;
        this.currency = currency;
    }
}
