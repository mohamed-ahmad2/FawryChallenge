package com.mycompany.fawrychallenge;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Customer {
    private Map<Product, Integer> cart = new HashMap<>();
    private double balance;

    public Customer(double balance) {
        this.balance = balance;
    }
    
    
    
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
    
    private boolean updateBalance(double total) {
        if (balance < total) {
            System.out.println("Insufficient balance");
            return false;
        }

        balance -= total;
        return true;
    }

    
   private void printDetailsForCheckout(double subtotal, double shippingFees, double total)   {
        System.out.println("** Checkout receipt **");

        for (var item : cart.entrySet()) {
            Product product = item.getKey();
            int quantity = item.getValue();
            double price = product.getPrice() * quantity;

            System.out.println(quantity + "x " + product.getName() + "\t\t" +  price);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal\t\t" +  subtotal);
        System.out.println("Shipping\t\t" +  shippingFees);
        System.out.println("Amount\t\t\t" +  total);
    }



    
    public void checkout() {
        if (!checkCartEmpty()) return;

        double subtotal = 0.0;
        double shippingFees = 0.0;
        double totalWeight = 0.0;
        Map<String, Double> shippableItems = new LinkedHashMap<>();

        for (var item : cart.entrySet()) {
            Product product = item.getKey();
            int quantity = item.getValue();

            if (!checkExpirationDate(product)) return;
            if (!checkQuantity(product, quantity)) return;

            subtotal += product.getPrice() * quantity;

            if (product.isShippable()) {
                shippingFees += product.getShippingFees() * quantity;
                totalWeight += product.getWeight() * quantity;

                double productWeightGrams = product.getWeight() * quantity * 1000;
                shippableItems.merge(product.getName(), productWeightGrams, Double::sum);
            }
        }

        double total = subtotal + shippingFees;

        if (!updateBalance(total)) return;

        for (var item : cart.entrySet()) {
            Product product = item.getKey();
            int quantity = item.getValue();
            product.setQuantity(product.getQuantity() - quantity);
        }

        ShippingService.send(shippableItems, totalWeight * 1000);
        printDetailsForCheckout(subtotal, shippingFees, total);

        cart.clear();
    }
}
