package com.microservice.product_service.controller;

import com.microservice.product_service.entity.Product;
import com.microservice.product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product getProduct = productService.getProductById(id);
        return ResponseEntity.ok(getProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }
}
