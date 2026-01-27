package com.microservice.product_service.service;

import com.microservice.product_service.entity.Product;
import com.microservice.product_service.exceptions.ProductAlreadyPresent;
import com.microservice.product_service.exceptions.ProductNotFound;
import com.microservice.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) throws ProductAlreadyPresent {
        Long id = product.getId();
        if(productRepo.findById(id).isPresent()){
            throw new ProductAlreadyPresent("Product with id "+ id +" already present");
        }
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFound {
        return productRepo.findById(id).orElseThrow(
                ()-> new ProductNotFound("Product with id " + id + " does not exist")
        );
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
