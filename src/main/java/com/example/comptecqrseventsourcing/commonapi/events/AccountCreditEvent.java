package com.example.comptecqrseventsourcing.commonapi.events;

import lombok.Getter;

public class AccountCreditEvent extends BaseEvent<String>{


    @Getter
    private double amount ;
    @Getter
    private String currency;

    public AccountCreditEvent(String AccountId, double amount, String currency) {
        super(AccountId);
        this.amount = amount;
        this.currency = currency;
    }
}
