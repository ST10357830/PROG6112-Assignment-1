/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

import carrental.SUV;
import carrental.Sedan;
import carrental.Truck;
import java.util.Scanner;
import service.RentalManager;

public class CarRentalApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            RentalManager manager = new RentalManager();
            
            // Sample cars
            manager.addCar(new Sedan("S1", "Toyota", "Camry", 55.0));
            manager.addCar(new SUV("SUV1", "Ford", "Explorer", 80.0));
            manager.addCar(new Truck("T1", "MAN", "TGX", 120.0));
            
            int choice = -1;  // ✅ fix here
            do {
                System.out.println("\n--- Car Rental System ---");
                System.out.println("1. Show available cars");
                System.out.println("2. Rent a car");
                System.out.println("3. Return a car");
                System.out.println("4. Show car report");
                System.out.println("5. Add Vehicle");
                System.out.println("6. Delete Vehicle");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                
                if (scanner.hasNextInt()) {   // avoid InputMismatchException
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // clear bad input
                    continue; // loop back
                }
                
                switch (choice) {
                    case 1 -> manager.showAvailableCars();
                    case 2 -> {
                        System.out.print("Enter Car ID to rent: ");
                        String rentId = scanner.nextLine();
                        manager.rentCar(rentId);
                    }
                    case 3 -> {
                        System.out.print("Enter Car ID to return: ");
                        String returnId = scanner.nextLine();
                        manager.returnCar(returnId);
                    }
                    case 4 -> manager.reportAllCars();
                    case 5 -> manager.addVehicle();
                    case 6 -> manager.deleteVehicle();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 0);
        }
    }
}


