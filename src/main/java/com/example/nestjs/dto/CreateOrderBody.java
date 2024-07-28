package com.example.nestjs.dto;

import javax.validation.constraints.NotNull;

public class CreateOrderBody {
    @NotNull(message = "产品ID不能为空")
    private String productId;
    @NotNull(message = "用户ID不能为空")
    private String userId;
    @NotNull(message = "购买量ID不能为空")
    private Integer quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
