/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

public class SUV extends Car {
    private final int seatingCapacity;

    public SUV(String carId, String brand, String model, double dailyRate) {
        super(carId, brand, model, dailyRate);
        this.seatingCapacity = 7;
    }

    @Override
    public String getCarSummary() {
        return super.getCarSummary() + " | Seats: " + seatingCapacity;
    }
}

