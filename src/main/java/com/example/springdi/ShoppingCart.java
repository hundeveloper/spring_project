package com.example.springdi;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}