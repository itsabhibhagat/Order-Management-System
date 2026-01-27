package com.microservice.product_service.entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    @Pattern(
            regexp = "^[A-Za-z ]+$",
            message = "Product name must contain only alphabets"
    )
    @Column(nullable = false)
    private String name;

    @Positive(message = "Price must be greater than 0")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
