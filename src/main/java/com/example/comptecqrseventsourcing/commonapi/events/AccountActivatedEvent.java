package com.example.comptecqrseventsourcing.commonapi.events;

import com.example.comptecqrseventsourcing.commonapi.Enums.AccountStatus;
import lombok.Getter;

public class AccountActivatedEvent extends  BaseEvent<String>{

@Getter private AccountStatus accountStatus;


    public AccountActivatedEvent(String id, AccountStatus accountStatus ) {
        super(id);
        this.accountStatus=accountStatus;

    }
}
