package com.example.springdi;

public class OrderService {
    private ShoppingCart cart;

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printOrder() {
        for (Product p : cart.getProducts()) {
            System.out.println(p);
        }
    }
}