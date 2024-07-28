package com.example.nestjs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonFormat(pattern = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonFormat(pattern = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonFormat(pattern = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonFormat(pattern = "date_time")
    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }
}
