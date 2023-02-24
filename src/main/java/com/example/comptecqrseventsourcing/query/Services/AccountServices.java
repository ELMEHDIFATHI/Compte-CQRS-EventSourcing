package com.example.comptecqrseventsourcing.query.Services;


import com.example.comptecqrseventsourcing.commonapi.events.AccountCreatedEvent;
import com.example.comptecqrseventsourcing.commonapi.events.AccountCreditEvent;
import com.example.comptecqrseventsourcing.query.Entity.Account;
import com.example.comptecqrseventsourcing.query.Reposotory.AccountRepo;
import com.example.comptecqrseventsourcing.query.Reposotory.OperationRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServices {


    private AccountRepo accountRepo;
    private OperationRepo operationRepo;
    @EventHandler
    public void on(AccountCreatedEvent event){
        log.info("$$$$$$$$$$$$$$$$$$$$$$$$");
        Account account=new Account();
        account.setId(event.getId());
        account.setBalance(event.getInitialBalance());
        account.setStatus(event.getAccountStatus());
        account.setCurrency(event.getCurrency());
        accountRepo.save(account);
    }

    /*
    @QueryHandler
    public List<Account> on(GetAllAccountsQuery Qyesry){
        return accountRepo.findAll()
    }

     */


    //on va continuer a jouer lesroles
}
