package com.example.nestjs.entity;

public class ProductEntity {
    private String id;
    private String name;
    private String unit;
    private Integer quantity;
    private Integer remaining;

    public ProductEntity() {
    }

    public ProductEntity(String id, String name, String unit, Integer quantity, Integer remaining) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.remaining = remaining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }
}
