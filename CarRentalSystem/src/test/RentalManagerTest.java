/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

import carrental.Car;
import carrental.SUV;
import carrental.Sedan;
import carrental.Truck;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import service.RentalManager;

public class RentalManagerTest {

    @Test
    public void testAddCar() {
        RentalManager manager = new RentalManager();
        Car car = new Sedan("S2", "BMW", "3 Series", 90.0);
        manager.addCar(car);
        assertEquals("S2", car.getCarId());
    }

    @Test
    public void testRentCar() {
        RentalManager manager = new RentalManager();
        Car car = new SUV("SUV2", "Jeep", "Cherokee", 70.0);
        manager.addCar(car);
        manager.rentCar("SUV2");
        assertTrue(car.isRented());
    }

    @Test
    public void testReturnCar() {
        RentalManager manager = new RentalManager();
        Car car = new Truck("T2", "Volvo", "FH16", 150.0);
        manager.addCar(car);
        manager.rentCar("T2");
        manager.returnCar("T2");
        assertFalse(car.isRented());
    }
}

