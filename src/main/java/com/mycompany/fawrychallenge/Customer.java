package com.mycompany.fawrychallenge;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private Map<Product, Integer> cart = new HashMap<>();
    private double balance;
    
    public void add(Product product, int quantity) {
        if (product != null && quantity <= product.getQuantity()) {
            cart.merge(product, quantity, Integer::sum);
        } else {
            System.out.println("Cannot add product: not enough stock.");
        }
    }
    
    
}
