package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        while (on) {
            displayMenu();
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByYearRequest();
                    break;
                case 3:
                    processGetByMakeModelRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Goodbye.");
                    on = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number corresponding to the action you would like to perform.");
            }
        }
    }
    public void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println(" ");
        System.out.println("1 Find vehicles within a price range");
        System.out.println("2 Find vehicles by year range");
        System.out.println("3 Find vehicles by make / model");
        System.out.println("4 Find vehicles by color");
        System.out.println("5 Find vehicles by mileage range");
        System.out.println("6 Find vehicles by type (car, truck, SUV)");
        System.out.println("7 List ALL vehicles");
        System.out.println("8 Add a vehicle");
        System.out.println("9 Remove a vehicle");
        System.out.println("99 Quit");
    }
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(scanner);
        displayVehicles(vehicles);
    }
    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(scanner);
        displayVehicles(vehicles);
    }
    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(scanner);
        displayVehicles(vehicles);

    }
    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(scanner);
        displayVehicles(vehicles);
    }
    public void processGetByMileageRequest() {
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage();
        displayVehicles(vehicles);

    }
    public void processGetByVehicleTypeRequest() {
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType();
        displayVehicles(vehicles);
    }
    public void processGetAllVehiclesRequest() {
        // Call dealership's get all vehicles method
        // Call displayVehicle's helper method passing list returned from getAllVehicles
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest () {

    }
}
