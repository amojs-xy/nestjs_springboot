package com.example.nestjs.controller;

import com.example.nestjs.dto.CreateOrderBody;
import com.example.nestjs.entity.ProductOrderEntity;
import com.example.nestjs.entity.ResponseEntity;
import com.example.nestjs.service.OrderService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/product-order")
public class OrderController {

    private final OrderService orderService;

    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order-create")
    public ResponseEntity<ProductOrderEntity> createOrder (@Valid @RequestBody CreateOrderBody body, BindingResult br) {
        if (body.getQuantity() == 0) {
            return new ResponseEntity<>(
                    1,
                    "购买量不能为0",
                    null
            );
        }

        if (br.hasErrors()) {
            return new ResponseEntity<>(
                    1,
                    Objects.requireNonNull(br.getFieldError()).getDefaultMessage(),
                    null
            );
        }

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
