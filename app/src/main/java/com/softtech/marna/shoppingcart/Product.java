package com.softtech.marna.shoppingcart;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String store;
    private BigDecimal price;
    private Integer count;

    public Product(String name, String store, BigDecimal price, int count) {
        this.name = name;
        this.store = store;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}