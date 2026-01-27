package com.microservice.inventory_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Table(name = "Inventory")
@Data
public class Inventory {

    @Id
    private Long productId;

    @PositiveOrZero
    @NotNull
    private Integer availableQuantity;

}
