package com.example.nestjs.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductEntity {
    private String id;
    private String name;
    private String unit;
    private Integer remaining;

    public ProductEntity() {
    }

    public ProductEntity(String id, String name, String unit, Integer remaining) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.remaining = remaining;
    }

}
