package com.sachin.rbc.exception;


public class EmptyBasketException extends RuntimeException {

    public EmptyBasketException(String message) {
        super(message);
    }
}
