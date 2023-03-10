package com.example.comptecqrseventsourcing.query.Entity;

import com.example.comptecqrseventsourcing.commonapi.Enums.OperationType;
import com.example.comptecqrseventsourcing.query.Entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Operation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Date date;
private double amount;

@Enumerated(EnumType.STRING)

private OperationType type;

@ManyToOne
private Account account;

}
