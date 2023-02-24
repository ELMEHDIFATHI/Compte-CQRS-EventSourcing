package com.example.comptecqrseventsourcing.commonapi.Exception;

public class AmountNegativeException extends RuntimeException {
    public AmountNegativeException(String message) {
        super(message);
    }
}
