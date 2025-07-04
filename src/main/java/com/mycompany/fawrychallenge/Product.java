
package com.mycompany.fawrychallenge;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean hasAnExpirationDate;
    private boolean Shippable;
    private double shippingFees; 

    public Product(String name, double price, int quantity, boolean hasAnExpirationDate, boolean Shippable, double shippingFees) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.hasAnExpirationDate = hasAnExpirationDate;
        this.Shippable = Shippable;
        this.shippingFees = shippingFees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isHasAnExpirationDate() {
        return hasAnExpirationDate;
    }

    public void setHasAnExpirationDate(boolean hasAnExpirationDate) {
        this.hasAnExpirationDate = hasAnExpirationDate;
    }

    public boolean isShippable() {
        return Shippable;
    }

    public void setShippable(boolean Shippable) {
        this.Shippable = Shippable;
    }

    public double getShippingFees() {
        if (Shippable) {
            return shippingFees;
        } 
        return 0.0;
    }


    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

   
    
}
