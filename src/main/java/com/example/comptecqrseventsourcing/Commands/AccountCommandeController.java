

package com.example.comptecqrseventsourcing.Commands;

import com.example.comptecqrseventsourcing.commonapi.Dtos.CreateAccountTRequestDto;
import com.example.comptecqrseventsourcing.commonapi.Dtos.CreditAccountTRequestDto;
import com.example.comptecqrseventsourcing.commonapi.Dtos.DebitAccountTRequestDto;
import com.example.comptecqrseventsourcing.commonapi.Enums.AccountStatus;
import com.example.comptecqrseventsourcing.commonapi.commands.CreatedAccountCommand;
import com.example.comptecqrseventsourcing.commonapi.commands.CreditAccountCommand;
import com.example.comptecqrseventsourcing.commonapi.commands.DebitAccountCommand;
import lombok.AllArgsConstructor;


import org.axonframework.commandhandling.gateway.CommandGateway;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping(path ="/commands/account")

@AllArgsConstructor
public class AccountCommandeController {

    private CommandGateway commandGateway;
    private EventStore eventStore;




    @GetMapping("/eventStore/{accountId}")
    public Stream eventStore(@PathVariable  String accountId){

        return eventStore.readEvents(accountId).asStream();

    }



    @PutMapping(path ="/credit")
    public CompletableFuture<String> creaditAccount(@RequestBody CreditAccountTRequestDto request){

        return commandGateway.send(new CreditAccountCommand(
                UUID.randomUUID().toString(),
                request.getAmount(),
                request.getCurrency()
        ));

    }

    @PutMapping(path ="/debit")
    public CompletableFuture<String> debitAccount(@RequestBody DebitAccountTRequestDto request){

        return commandGateway.send(new DebitAccountCommand(
                UUID.randomUUID().toString(),
                request.getAmount(),
                request.getCurrency()

        ));

    }


    @PostMapping(path ="/create")
    public CompletableFuture<String> createAccount(@RequestBody  CreateAccountTRequestDto request){

        return commandGateway.send(new CreatedAccountCommand(
                UUID.randomUUID().toString(),
                request.getInitialBalance(),
                request.getCurrency()

        ));

    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionsHandler(Exception exception){
            ResponseEntity<String> entity=new ResponseEntity<>(
                    exception.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
            return entity;
    }
}


