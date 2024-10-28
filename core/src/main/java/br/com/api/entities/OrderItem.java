package br.com.api.entities;

import java.math.BigDecimal;

public class OrderItem {
    
    private Long id;
    private Product product;
    private Integer amount;
    private BigDecimal subTotal;

    public OrderItem(){}

    public OrderItem(Long id, Product product, Integer amount, BigDecimal subTotal) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    

}
