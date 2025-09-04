/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

public class Sedan extends Car {
    private boolean luxury;

    public Sedan(String carId, String brand, String model, double dailyRate) {
        super(carId, brand, model, dailyRate);
        this.luxury = luxury;
    }

    @Override
    public String getCarSummary() {
        return super.getCarSummary() + " | Luxury: " + (luxury ? "Yes" : "No");
    }
}

