package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Dealership {
    Scanner scanner = new Scanner(System.in);
    String name;
    String address;
    String phone;

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }
    public ArrayList<Vehicle> getVehiclesByPrice(Scanner scanner) {
        System.out.println("Enter the minimum vehicle price.");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter the maximum vehicle price.");
        double maxPrice = scanner.nextDouble();

        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(Scanner scanner) {
        System.out.println("Enter the desired make of vehicle");
        String make = scanner.nextLine();
        System.out.println("Enter the desired model of vehicle");
        String model = scanner.nextLine();

        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                 result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByYear(Scanner scanner) {
        System.out.println("Enter the oldest year of vehicle you would like to search.");
        int oldestYear = scanner.nextInt();
        System.out.println("Enter the newest year of vehicle you would like to search.");
        int newestYear = scanner.nextInt();

        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle: inventory) {
            if (vehicle.getYear() >= oldestYear && vehicle.getYear() <= newestYear); {
                result.add(vehicle);
            }

        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByColor(Scanner scanner) {
        System.out.println("Enter the color of vehicle you'd like to search for.");
        String color = scanner.nextLine();

        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(Scanner scanner) {
        System.out.println("What's the minimum odometer rating for vehicles you would like to search?");
        int minMiles = scanner.nextInt();
        System.out.println("What's the maximum odometer rating for vehicles you would like to search?");
        int maxMiles = scanner.nextInt();

        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= minMiles && vehicle.getOdometer() <= maxMiles) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByType(Scanner scanner) {
        System.out.println("What type of vehicle are you searching for?");
        String type = scanner.nextLine();

        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void addVehicle(Scanner scanner) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        System.out.println("Enter the VIN of the vehicle you would like to add.");
        int vin = scanner.nextInt();

        System.out.println("Enter the year of the vehicle you would like to add.");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the vehicle make.");
        String make = scanner.nextLine();

        System.out.println("Enter the vehicle model.");
        String model = scanner.nextLine();

        System.out.println("Enter the type of vehicle.");
        String type = scanner.nextLine();

        System.out.println("Enter the color of the vehicle.");
        String color = scanner.nextLine();

        System.out.println("Enter the mileage of the vehicle.");
        int odometer = scanner.nextInt();

        System.out.println("Enter the price of the vehicle.");
        double price = scanner.nextDouble();

        System.out.println("Thank you! Vehicle has been added.");

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        vehicles.add(vehicle); //Add vehicle to array and to file
        inventory.add(vehicle);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Student\\Desktop\\pluralsight\\workshops\\VehicleDealership\\VehicleDealership\\src\\main\\resources\\dealership.csv", true))) {
            String line = vehicle.getVin() + "|" +
                    vehicle.getVin() + "|" +
                    vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" +
                    vehicle.getColor() + "|" +
                    vehicle.getType() + "|" +
                    vehicle.getOdometer() + "|" +
                    vehicle.getPrice();
            bw.write(line);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error writing to file");
        }


    }
    public void removeVehicle() {

    }
}
