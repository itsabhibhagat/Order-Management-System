package com.microservice.inventory_service.controller;

import com.microservice.inventory_service.entity.Inventory;
import com.microservice.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
        Inventory inv = inventoryService.createInventory(inventory);
        return new ResponseEntity<>(inv, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long productId){
        Inventory inventory = inventoryService.getInventoryById(productId);
        return ResponseEntity.ok(inventory);
    }

    @PutMapping("/{productId}/reserve")
    public ResponseEntity<?> reserveInventory(@PathVariable Long productId,@RequestParam int quantity){
        inventoryService.reserve(productId,quantity);
        return ResponseEntity.ok().body(quantity + " product with productId " + productId + " has been reserved"
        );
    }
}
