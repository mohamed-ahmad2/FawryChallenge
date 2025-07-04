package com.mycompany.fawrychallenge;

public class Product implements ShippableProduct {
    private String name;
    private double price, shippingFees, weight;;
    private int quantity;
    private boolean hasAnExpirationDate, shippable;

    public Product(String name, double price, int quantity, boolean hasAnExpirationDate, boolean shippable, double shippingFees, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.hasAnExpirationDate = hasAnExpirationDate;
        this.shippable = shippable;
        this.shippingFees = shippingFees;
        this.weight = weight;
    }

    @Override
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
        return shippable; 
    }
    
    public void setShippable(boolean shippable) { 
        this.shippable = shippable; 
    }

    public double getShippingFees() {
        return shippable ? shippingFees : 0.0;
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    @Override
    public double getWeight() {
        return shippable ? weight : 0.0;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
