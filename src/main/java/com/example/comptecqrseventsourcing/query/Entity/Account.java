package com.example.comptecqrseventsourcing.query.Entity;

import com.example.comptecqrseventsourcing.commonapi.Enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Account {

    @Id
    private String id;
    private double balance;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private String currency;

    @OneToMany(mappedBy = "account")
    private Collection<Operation> operations;
}
