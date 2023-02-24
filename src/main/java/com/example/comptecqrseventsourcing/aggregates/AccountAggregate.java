package com.example.comptecqrseventsourcing.aggregates;

import com.example.comptecqrseventsourcing.commonapi.Enums.AccountStatus;
import com.example.comptecqrseventsourcing.commonapi.Exception.AmountNegativeException;
import com.example.comptecqrseventsourcing.commonapi.Exception.BallanceNotSufusant;
import com.example.comptecqrseventsourcing.commonapi.commands.CreatedAccountCommand;
import com.example.comptecqrseventsourcing.commonapi.commands.CreditAccountCommand;
import com.example.comptecqrseventsourcing.commonapi.commands.DebitAccountCommand;
import com.example.comptecqrseventsourcing.commonapi.events.AccountActivatedEvent;
import com.example.comptecqrseventsourcing.commonapi.events.AccountCreditEvent;
import com.example.comptecqrseventsourcing.commonapi.events.AccountCreatedEvent;
import com.example.comptecqrseventsourcing.commonapi.events.AccountDebitedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String AccountId;
    private double balance;
    private String currency;

    private AccountStatus status;

    public AccountAggregate() {
    }


    @CommandHandler
    public AccountAggregate(CreatedAccountCommand createdAccountCommand) {
        if(createdAccountCommand.getInitialBalance()<0) throw new RuntimeException("Impossible ...");

        AggregateLifecycle.apply(new AccountCreatedEvent(
                createdAccountCommand.getId(),
                createdAccountCommand.getInitialBalance(),
                createdAccountCommand.getCurrency(),
                AccountStatus.CREATED


        ));

    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.AccountId= event.getId();
        this.balance= event.getInitialBalance();
        this.status=AccountStatus.CREATED;
        this.currency=event.getCurrency();
        AggregateLifecycle.apply(new AccountActivatedEvent(
                event.getId(),
                AccountStatus.ACTIVATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent event){
      this.status=event.getAccountStatus();
    }


    @CommandHandler
    public void handler(CreditAccountCommand command){
        if(command.getAmount()<0) {
            throw  new AmountNegativeException("impossible amount ne peut pas etre negative ");
        }
        if(this.AccountId != command.getId()) throw new RuntimeException("not dount ...");

        AggregateLifecycle.apply(new AccountCreditEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()

        ));
    }

    @EventSourcingHandler
    public void on(AccountCreditEvent event){
        if(AccountId ==null)throw  new RuntimeException("eureue ");
        this.AccountId = event.getId();
        this.balance+=event.getAmount();
    }

    @CommandHandler
    public void handler(DebitAccountCommand command){
        if(command.getAmount()<0) {
            throw  new AmountNegativeException("impossible amount ne peut pas etre negative ");
        }
        if(this.balance<command.getAmount()) {
            throw  new BallanceNotSufusant("balance not suffisant ");
        }


        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()

        ));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent event){

        this.balance-=event.getAmount();
    }





}
