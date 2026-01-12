package com.microservice.order_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "${product-service.url}")
public interface ProductFeign {

    @GetMapping("/products/{id}")
    Object getProductById(@PathVariable Long id);
}
