package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DealershipFileManager {

    public Dealership getDealership() {
        System.out.println("Attempting to load dealership data...");
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Student\\Desktop\\pluralsight\\workshops\\VehicleDealership\\VehicleDealership\\src\\main\\resources\\dealership.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");

                // Check if line defines a dealership
                if (dealership == null && values.length == 3) {
                    System.out.println("Creating dealership with values: " + Arrays.toString(values));
                    dealership = new Dealership(
                            values[0],
                            values[1],
                            values[2]);

                } else if (values.length == 8) {
                    Vehicle vehicle = new Vehicle(
                            Integer.parseInt(values[0]),
                            Integer.parseInt(values[1]),
                            values[2],
                            values[3],
                            values[4],
                            values[5],
                            Integer.parseInt(values[6]),
                            Double.parseDouble(values[7]));

                    dealership.addVehicle(vehicle);
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found:" + fnfe.getMessage());

        }
        catch (IOException ioe) {
            System.out.println("I/O error" + ioe.getMessage());

        }
        catch (Exception e) {
            System.out.println("General error" + e.getMessage());
            e.printStackTrace();
        }

        if (dealership == null) {
            System.out.println("No dealership data found in the file");
        }
        return dealership;

    }
    public void saveDealership() {

    }
}
