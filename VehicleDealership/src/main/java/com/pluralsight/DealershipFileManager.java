package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader("dealership.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");

                // Check if line defines a dealership
                if (dealership == null && values.length == 3) {
                    dealership = new Dealership(values[0], values[1], values[2]);

                } else if (values.length == 8) {
                    Vehicle vehicle = new Vehicle(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
                    vehicles.add(vehicle);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return null;

    }
    public void saveDealership() {

    }
}
