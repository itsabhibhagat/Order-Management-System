package com.microservice.product_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductGlobalExceptionHandler {

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFound ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(ProductAlreadyPresent.class)
    public ResponseEntity<String> handleProductAlreadyExist(ProductAlreadyPresent ex){
        return ResponseEntity.status(201).body(ex.getMessage());
    }

}


