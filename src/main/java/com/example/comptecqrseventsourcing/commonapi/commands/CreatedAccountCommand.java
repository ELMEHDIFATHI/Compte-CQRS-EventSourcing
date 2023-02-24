package com.example.comptecqrseventsourcing.commonapi.commands;


import lombok.Getter;

public class CreatedAccountCommand  extends BaseCommand<String> {

    @Getter private double initialBalance;

    @Getter private String currency;

    public CreatedAccountCommand(String id, double initialBalance, String currency) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }
}
