/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

import carrental.Car;
import carrental.SUV;
import carrental.Sedan;
import carrental.Truck;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalManager {
    private final ArrayList<Car> cars;
      private final Scanner scanner;

    public RentalManager() {
        cars = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void showAvailableCars() {
        System.out.println("\n--- Available Cars ---");
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.println(car.getCarSummary());
            }
        }
    }

    public void rentCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isRented()) {
                car.rentCar();
                System.out.println("Car " + carId + " rented successfully!");
                return;
            }
        }
        System.out.println("Car not available.");
    }

    public void returnCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isRented()) {
                car.returnCar();
                System.out.println("Car " + carId + " returned successfully!");
                return;
            }
        }
        System.out.println("Car not found or not rented.");
    }

    public void reportAllCars() {
        System.out.println("\n--- Full Car Report ---");
        for (Car car : cars) {
            System.out.println(car.getCarSummary());
        }
    }
    
    public void addVehicle() {
        System.out.print("Enter Car ID: ");
        String carId = scanner.nextLine();

        System.out.print("Enter Car Type (Sedan/SUV/Truck): ");
        String type = scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Daily Rate: ");
        double rate = Double.parseDouble(scanner.nextLine());

        Car newCar;

        switch (type.toLowerCase()) {
            case "sedan" -> newCar = new Sedan(carId, brand, model, rate);
            case "suv" -> newCar = new SUV(carId, brand, model, rate);
            case "truck" -> newCar = new Truck(carId, brand, model, rate);
            default -> {
                System.out.println("❌ Invalid type. Vehicle not added.");
                return;
            }
        }

        cars.add(newCar);
        System.out.println("✅ Vehicle added successfully!");
    }
    
    public void deleteVehicle() {
        System.out.print("Enter Car ID to delete: ");
        String id = scanner.nextLine();

        Car toDelete = null;
        for (Car c : cars) {
            if (c.getCarId().equalsIgnoreCase(id)) {
                toDelete = c;
                break;
            }
        }

        if (toDelete != null) {
            cars.remove(toDelete);
            System.out.println("✅ Vehicle deleted successfully!");
        } else {
            System.out.println("❌ Vehicle with ID " + id + " not found.");
        }
    }
}

