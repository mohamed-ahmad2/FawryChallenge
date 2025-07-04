
package com.mycompany.fawrychallenge;

public class FawryChallenge {

    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 20.0, 10, false, true, 5.0, 1.0);
        Product tv = new Product("TV", 3000.0, 5, false, true, 100.0, 15.0);
        Product scratchCard = new Product("Mobile Scratch Card", 10.0, 50, false, false, 0.0, 0.0);
        //Product expiredProduct = new Product("Old Biscuits", 15.0, 10, true, true, 3.0, 0.5);

        Customer customer = new Customer(5000.0);

        customer.add(cheese, 2);
        customer.add(tv, 1);
        customer.add(scratchCard, 5);
        //customer.add(expiredProduct, 1);

        customer.checkout();
    }
}
