package com.ng.edu.binghamuni.park.Domain;

import java.util.ArrayList;
import java.util.List;

// Manufacturer class represents the company that produces cars
class Manufacturer {
    private String name;
    private String country;

    public Manufacturer(String toyota, String japan) {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructors, getters, setters

    // Other methods as needed
}

// Car class represents individual cars in the inventory
class Car {
    private String vin; // Vehicle Identification Number
    private String model;
    
    private int year;
    private double price;
    private String manufacturer;

    public Car(String s, String camry, int i, double v, Manufacturer toyota) {
    }

    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public double getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer =  manufacturer;
    }


    // Constructors, getters, setters

    // Other methods as needed
}

// Inventory class manages the list of cars available in the inventory
class Inventory {
    private List<Car> cars;

    public Inventory() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }

    // Other methods as needed
}

// Main class to demonstrate the usage of the car inventory app
public class CarInventoryApp {
    public static void main(String[] args) {
        // Create manufacturers
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        Manufacturer ford = new Manufacturer("Ford", "USA");

        // Create cars
        Car camry = new Car("123456789", "Camry", 2022, 25000.0, toyota);
        Car mustang = new Car("987654321", "Mustang", 2023, 45000.0, ford);

        // Create inventory and add cars
        Inventory inventory = new Inventory();
        inventory.addCar(camry);
        inventory.addCar(mustang);

        // Retrieve all cars from the inventory
        List<Car> allCars = inventory.getAllCars();
        for (Car car : allCars) {
            System.out.println("VIN: " + car.getVin() +
                    ", Model: " + car.getModel() +
                    ", Year: " + car.getYear() +
                    ", Price: $" + car.getPrice() +
                    ", Manufacturer: " + car.getManufacturer()
            );
        }
    }
}
