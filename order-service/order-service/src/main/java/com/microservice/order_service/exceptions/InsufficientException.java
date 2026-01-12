package com.microservice.order_service.exceptions;

public class InsufficientException extends RuntimeException{
    public InsufficientException(String msg){
        super(msg);
    }
}
