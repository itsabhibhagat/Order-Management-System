package com.microservice.inventory_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.inventory_service.entity.Inventory;
import com.microservice.inventory_service.exception.InsufficientStockException;
import com.microservice.inventory_service.exception.ResourceNotFoundException;
import com.microservice.inventory_service.repository.InventoryRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }



    @Override
    public Inventory getInventoryById(Long productId) {

        return inventoryRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product with productId "+ productId + " not found")
        );
    }

    @Override
    @Transactional
    public void reserve(Long productId, int quantity) {

        Inventory inventory = inventoryRepository.findById(productId)
                        .orElseThrow(()->
                                new ResourceNotFoundException("Product with productId "+ productId + " not found"));

        log.info("Reservation attempt for product ", productId);


        if(inventory.getAvailableQuantity() < quantity){
            throw new InsufficientStockException("Not enough stock");
        }

        inventory.setAvailableQuantity(
                inventory.getAvailableQuantity() - quantity
        );
    }
}
