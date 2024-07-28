package com.example.nestjs.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductOrderEntity {

    private String id;
    private String productId;
    private String userId;
    private String productName;
    private Integer quantity;
    private long dateTime;

    public ProductOrderEntity() {
    }

    public ProductOrderEntity(String id, String productId, String userId, String productName, Integer quantity, long dateTime) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }
}
