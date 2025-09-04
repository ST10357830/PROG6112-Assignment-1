/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

public class Car {
    private final String carId;
    private final String brand;
    private final String model;
    private final double dailyRate;
    private boolean rented;

    public Car(String carId, String brand, String model, double dailyRate) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.rented = false;
    }

    // Getters and setters
    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getDailyRate() { return dailyRate; }
    public boolean isRented() { return rented; }

    public void rentCar() { this.rented = true; }
    public void returnCar() { this.rented = false; }

    public String getCarSummary() {
        return carId + " - " + brand + " " + model + " | Rate: $" + dailyRate + " | " + 
               (rented ? "RENTED" : "AVAILABLE");
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

