package com.mycompany.fawrychallenge;

import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void send(Map<String, Double> itemWeights, double totalG) {
        System.out.println("** Shipment notice **");

        for (var item : itemWeights.entrySet()) {
            String name = item.getKey();
            double weightG = item.getValue();
            System.out.println(name + "\t\t" + (int) weightG + "g");
        }

        double totalKg = totalG / 1000.0;
        System.out.println("Total package weight " + totalKg + "kg");
        System.out.println();
    }
}
