package com.microservice.order_service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service", url = "${inventory-service.url}")
public interface InventoryFeign {

    @GetMapping("/inventory/{productId}")
    Object getInventoryById(@PathVariable Long productId);

    @PutMapping("/inventory/{productId}/reserve")
    void reserve(@PathVariable Long productId, @RequestParam Integer quantity);

}
