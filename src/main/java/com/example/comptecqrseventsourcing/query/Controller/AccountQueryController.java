package com.example.comptecqrseventsourcing.query.Controller;

import com.example.comptecqrseventsourcing.query.Entity.Account;
import org.axonframework.queryhandling.QueryGateway;

import java.util.List;

public class AccountQueryController {
    private QueryGateway queryGateway;


    public List<Account> accountList(){
       // queryGateway.query(new GetALLQueryAcoount())

        return null;
    }

}
