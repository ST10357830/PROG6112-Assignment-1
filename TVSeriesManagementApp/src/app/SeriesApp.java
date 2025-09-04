/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Khwinana Kabelo Makibelo 
 */

import service.Series;
import java.util.Scanner;

public class SeriesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series service = new Series();

        while (true) {
            System.out.println("\nLATEST SERIES – 2025");
            System.out.println("*************************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String input = scanner.nextLine();
            if (!input.equals("1")) {
                service.exitSeriesApplication();
            }

            System.out.println("\nPlease select one of the following items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report.");
            System.out.println("(6) Filter by Genre.");
            System.out.println("(7) Sort Series by Name.");
            System.out.println("(8) Show Top Rated Series.");
            System.out.println("(9) Count Series by Viewer Age.");
            System.out.println("(10) Exit Application.");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> service.captureSeries();
                case "2" -> service.searchSeries();
                case "3" -> service.updateSeries();
                case "4" -> service.deleteSeries();
                case "5" -> service.seriesReport();
                case "6" -> {  
                    System.out.print("Enter genre to filter by: ");
                    String genre = scanner.nextLine();
                    service.filterByGenre(genre);
                }
                case "7" -> service.sortSeriesByName(); 
                case "8" -> service.topRatedSeries();   
                case "9" -> {
                    System.out.print("Enter age to count suitable series: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    service.countSeriesByAge(age);
                }
                case "10" -> service.exitSeriesApplication();
                default -> System.out.println("❌ Invalid option! Try again.");
            }
        }
    }
}

