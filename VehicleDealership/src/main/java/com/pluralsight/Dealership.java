package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

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
    public ArrayList<Vehicle> getVehiclesByPrice() {
        return inventory;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel() {
        return inventory;
    }
    public ArrayList<Vehicle> getVehiclesByYear() {
        return inventory;
    }
    public ArrayList<Vehicle> getVehiclesByColor() {
        return inventory;
    }
    public ArrayList<Vehicle> getVehiclesByMileage() {
        return inventory;
    }
    public ArrayList<Vehicle> getVehiclesByType() {
        return inventory;
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


    }
    public void removeVehicle() {

    }
}
