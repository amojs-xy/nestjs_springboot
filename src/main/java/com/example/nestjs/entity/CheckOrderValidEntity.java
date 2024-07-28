package com.example.nestjs.entity;

public class CheckOrderValidEntity {
    private ProductEntity product;
    private Integer quantity;

    public CheckOrderValidEntity() {
    }

    public CheckOrderValidEntity(ProductEntity product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
