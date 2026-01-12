package com.microservice.product_service.service;

import com.microservice.product_service.entity.Product;
import com.microservice.product_service.exceptions.ProductAlreadyPresent;
import com.microservice.product_service.exceptions.ProductNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product) throws ProductAlreadyPresent;

    Product getProductById(Long id) throws ProductNotFound;

    List<Product> getAllProducts();
}
