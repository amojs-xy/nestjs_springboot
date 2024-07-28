package com.example.nestjs.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckOrderValidEntity {
    private ProductEntity product;
    private Integer quantity;

    public CheckOrderValidEntity() {
    }

    public CheckOrderValidEntity(ProductEntity product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

}
