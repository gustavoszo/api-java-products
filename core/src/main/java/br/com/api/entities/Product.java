package br.com.api.entities;

import java.util.UUID;

import br.com.api.exceptions.ValidationException;

import java.math.BigDecimal;

import java.time.LocalDateTime;

public class Product {
    
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantityAvaiable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(){}

    public Product(UUID id, String name, String description, BigDecimal price, Integer quantityAvaiable, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        setPrice(price);
        this.quantityAvaiable = quantityAvaiable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String name, String description, BigDecimal price ,Integer quantityAvaiable) {
        this.name = name;
        this.description = description;
        setPrice(price);
        this.quantityAvaiable = quantityAvaiable;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price != null) {
            if (price.compareTo(BigDecimal.ZERO) == -1) throw new ValidationException("Preço do valor deve ser maior que 0");
            this.price = price;
        }
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getQuantityAvaiable() {
        return quantityAvaiable;
    }
    public void setQuantityAvaiable(Integer quantityAvaiable) {
        this.quantityAvaiable = quantityAvaiable;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
  
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    

}
