/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

public class Truck extends Car {
    private final double loadCapacity;

    public Truck(String carId, String brand, String model, double dailyRate) {
        super(carId, brand, model, dailyRate);
        this.loadCapacity = 1000;
    }

    @Override
    public String getCarSummary() {
        return super.getCarSummary() + " | Load: " + loadCapacity + " tons";
    }
}

