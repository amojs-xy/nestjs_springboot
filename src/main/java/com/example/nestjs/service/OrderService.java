package com.example.nestjs.service;

import com.example.nestjs.entity.CheckOrderValidEntity;
import com.example.nestjs.entity.ProductOrderEntity;
import com.example.nestjs.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public ProductOrderEntity createOrder(String productId, String userId, Integer quantity) {
        CheckOrderValidEntity productInfo = orderRepository.checkOrderValid(productId, quantity);

        if (productInfo.getProduct() == null) {
            return null;
        }

        String productName = productInfo.getProduct().getName();

        if (productInfo.getQuantity() == 0) {
            return new ProductOrderEntity(
                    "",
                    productId,
                    userId,
                    productName,
                    0,
                   0
            );
        }

        return orderRepository.createOrder(
                productId,
                productName,
                userId,
                quantity
        );
    }
}
