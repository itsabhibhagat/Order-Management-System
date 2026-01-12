package com.microservice.product_service.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String msg){
        super(msg);
    }
}
