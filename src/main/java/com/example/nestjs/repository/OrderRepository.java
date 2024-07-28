package com.example.nestjs.repository;

import com.example.nestjs.entity.CheckOrderValidEntity;
import com.example.nestjs.entity.ProductEntity;
import com.example.nestjs.entity.ProductOrderEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderRepository {
    private final ObjectMapper objectMapper;

    public OrderRepository (
            ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
    }

    public CheckOrderValidEntity checkOrderValid (String productId, Integer quantity) {
        try {
            List<ProductEntity> productList = objectMapper.readValue(
                    new File("G:/workspace/java/nestjs/src/main/java/com/example/nestjs/data/product.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, ProductEntity.class)
            );

            ProductEntity productInfo = null;

            for (ProductEntity p: productList) {
                if (Objects.equals(p.getId(), productId)) {
                    productInfo = p;
                }
            }

            if (productInfo == null) {
                return new CheckOrderValidEntity(null, 0);
            }

            if (productInfo.getRemaining() < quantity) {
                return new CheckOrderValidEntity(productInfo, 0);
            }

            return new CheckOrderValidEntity(productInfo, quantity);
        } catch (IOException e) {
            return new CheckOrderValidEntity(null, 0);
        }
    }

    public ProductOrderEntity createOrder (String productId, String productName, String userId, Integer quantity) {
        ProductOrderEntity productOrder = new ProductOrderEntity(
                String.valueOf(System.currentTimeMillis()),
                productId,
                userId,
                productName,
                quantity,
                System.currentTimeMillis()
        );

        try {
            List<ProductOrderEntity> productOrderList = objectMapper.readValue(
                    new File("G:/workspace/java/nestjs/src/main/java/com/example/nestjs/data/product-order.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, ProductOrderEntity.class)
            );

            productOrderList.add(productOrder);

            objectMapper.writeValue(new File("G:/workspace/java/nestjs/src/main/java/com/example/nestjs/data/product-order.json"), productOrderList);

            try {

                List<ProductEntity> productList = objectMapper.readValue(
                        new File("G:/workspace/java/nestjs/src/main/java/com/example/nestjs/data/product.json"),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, ProductEntity.class)
                );

                for (ProductEntity p: productList) {
                    if (Objects.equals(p.getId(), productId)) {
                        p.setRemaining(p.getRemaining() - quantity);
                    }
                }

                objectMapper.writeValue(new File("G:/workspace/java/nestjs/src/main/java/com/example/nestjs/data/product.json"), productList);

                return productOrder;
            } catch (IOException e) {
                return null;
            }

        } catch (IOException e) {
            return null;
        }
    }
}
