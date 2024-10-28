package br.com.api.entities;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.api.entities.enums.StatusOrder;

import java.util.List;
import java.time.LocalDateTime;

public class Order {
    
    private UUID id; 
    private User user;
    private List<OrderItem> itens;
    private BigDecimal total;
    private StatusOrder status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(){}

    public Order(UUID id, User user, List<OrderItem> itens, BigDecimal total, StatusOrder status, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.itens = itens;
        this.total = total;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Order(User user, List<OrderItem> itens, StatusOrder status) {
        this.user = user;
        this.itens = itens;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getitens() {
        return itens;
    }
    public void setitens(List<OrderItem> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public StatusOrder getStatus() {
        return status;
    }
    public void setStatus(StatusOrder status) {
        this.status = status;
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
