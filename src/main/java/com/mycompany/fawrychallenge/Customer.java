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
    
    private boolean checkCartEmpty() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return false;
        }
        return true;
    }

    
    private boolean checkExpirationDate(Product product) {
        if (product.isHasAnExpirationDate()) {
            System.out.println("Product " + product.getName() + " is expired.");
            return false;
        }
        return true;
    }

    
    private boolean checkQuantity(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("Product " + product.getName() + " is out of stock.");
            return false;
        }
        return true;
    }

    
    public void checkout() {
        if (!checkCartEmpty()) return;

        double subtotal = 0.0;
        double shippingFees = 0.0;
        double totalWeight = 0.0;

        for (var item : cart.entrySet()) {
            Product product = item.getKey();
            int quantity = item.getValue();

            if (!checkExpirationDate(product)) return;
            if (!checkQuantity(product, quantity)) return;

            subtotal += product.getPrice() * quantity;

            if (product.isShippable()) {
                shippingFees += product.getShippingFees() * quantity;
                totalWeight += product.getWeight() * quantity;
            }
        }

        double total = subtotal + shippingFees;

        if (balance < total) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= total;

        for (var item : cart.entrySet()) {
            Product product = item.getKey();
            int quantity = item.getValue();
            product.setQuantity(product.getQuantity() - quantity);
        }

        System.out.println("Order Subtotal: " + subtotal);
        System.out.println("Shipping Fees: " + shippingFees);
        System.out.println("Total Shipping Weight: " + totalWeight + " kg");
        System.out.println("Total Paid: " + total);
        System.out.println("Remaining Balance: " + balance);

        cart.clear();
    }



}
