package com.example.comptecqrseventsourcing.commonapi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {
    @TargetAggregateIdentifier
    @Getter
    //represent l agrgat sur quel en va excuter
    // qye les getter
    private T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}
