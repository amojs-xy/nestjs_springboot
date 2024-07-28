package com.example.nestjs.controller;

import com.example.nestjs.dto.CreateOrderBody;
import com.example.nestjs.entity.ProductOrderEntity;
import com.example.nestjs.entity.ResponseEntity;
import com.example.nestjs.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/product-order")
public class OrderController {

    private final OrderService orderService;

    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order-create")
    public ResponseEntity<ProductOrderEntity> createOrder (@RequestBody CreateOrderBody body) {
        String productId = body.getProductId();
        String userId = body.getUserId();
        Integer quantity = body.getQuantity();

        ProductOrderEntity poe = orderService.createOrder(
                productId,
                userId,
                quantity
        );

        if (poe == null) {
            return new ResponseEntity<>(
                        1,
                        "未找到该产品",
                        null
                    );
        }

        if (Objects.equals(poe.getId(), "")) {
            return new ResponseEntity<>(
                    2,
                    "该产品库存不足购买量",
                    null
            );
        }

        return new ResponseEntity<>(
                0,
                "ok",
                poe
        );
    }
}
