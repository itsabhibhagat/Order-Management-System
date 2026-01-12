package com.microservice.inventory_service.service;

import com.microservice.inventory_service.entity.Inventory;

public interface InventoryService {

    public Inventory createInventory(Inventory inventory);

    public Inventory getInventoryById(Long productId);

    public void reserve(Long productId, int quantity);
}
