package com.microservice.product_service.exceptions;

public class ProductAlreadyPresent extends RuntimeException{
    public  ProductAlreadyPresent(String msg){
        super(msg);
    }
}
