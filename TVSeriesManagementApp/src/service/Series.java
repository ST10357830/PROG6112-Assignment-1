/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

import model.SeriesModel;
import model.AnimeSeries;
import model.DocumentarySeries;
import model.ComedySeries;
import model.DramaSeries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Series {
    // Keep public for JUnit access OR provide a getter
    public List<SeriesModel> seriesList;
    private final Scanner scanner;

    public Series() {
        this.seriesList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Interactive CRUD Methods
    public void captureSeries() {
        try {
            System.out.print("Enter Series ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Series Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Genre: ");
            String genre = scanner.nextLine();

            System.out.print("Enter Episodes: ");
            int episodes = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Rating (1–10): ");
            double rating = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter Release Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Age Restriction (2–18): ");
            int ageRestriction = Integer.parseInt(scanner.nextLine());

            // Choose type of series
            System.out.println("Select type of Series:");
            System.out.println("1. Regular Series");
            System.out.println("2. Anime");
            System.out.println("3. Documentary");
            System.out.println("4. Comedy");
            System.out.println("5. Drama");
            String choice = scanner.nextLine();

            SeriesModel series;
            switch (choice) {
                case "2" -> {
                    System.out.print("Enter Studio: ");
                    String studio = scanner.nextLine();
                    series = new AnimeSeries(id, name, genre, episodes, rating, year, ageRestriction, studio);
                }
                case "3" -> {
                    System.out.print("Enter Narrator: ");
                    String narrator = scanner.nextLine();
                    series = new DocumentarySeries(id, name, genre, episodes, rating, year, ageRestriction, narrator);
                }
                case "4" -> {
                    System.out.print("Enter Comedian: ");
                    String comedian = scanner.nextLine();
                    series = new ComedySeries(id, name, genre, episodes, rating, year, ageRestriction, comedian);
                }
                case "5" -> {
                    System.out.print("Enter Lead Actor: ");
                    String leadActor = scanner.nextLine();
                    series = new DramaSeries(id, name, genre, episodes, rating, year, ageRestriction, leadActor);
                }
                default -> series = new SeriesModel(id, name, genre, episodes, rating, year, ageRestriction);
            }

            seriesList.add(series);
            System.out.println("✅ Series captured successfully!");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error capturing series. Please try again.");
        }
    }

    public void searchSeries() {
        System.out.print("Enter Series ID to search: ");
        int id = Integer.parseInt(scanner.nextLine());

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            System.out.println(found.getSeriesSummary());
        } else {
            System.out.println("❌ Series not found.");
        }
    }

    public void updateSeries() {
        System.out.print("Enter Series ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            System.out.print("Enter new Age Restriction: ");
            int newAge = Integer.parseInt(scanner.nextLine());
            found.setAgeRestriction(newAge);
            System.out.println("✅ Series updated successfully!");
        } else {
            System.out.println("❌ Series not found.");
        }
    }

    public void deleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deleted = deleteSeriesById(id);
        if (deleted) {
            System.out.println("✅ Series deleted successfully!");
        } else {
            System.out.println("❌ Series not found.");
        }
    }

    public void seriesReport() {
        System.out.println("\n----- SERIES REPORT -----");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        }
        for (SeriesModel s : seriesList) {
            System.out.println(s.getSeriesSummary());
        }
        System.out.println("-------------------------");
    }

    public void exitSeriesApplication() {
        System.out.println("👋 Exiting application. Goodbye!");
        System.exit(0);
    }

    // Helper Methods (Testable)
    public SeriesModel findSeriesById(int id) {
        return seriesList.stream().filter(s -> s.getSeriesId() == id).findFirst().orElse(null);
    }

    public boolean deleteSeriesById(int id) {
        SeriesModel toRemove = findSeriesById(id);
        if (toRemove != null) {
            seriesList.remove(toRemove);
            return true;
        }
        return false;
    }

    public SeriesModel getTopRated() {
        return seriesList.stream().max(Comparator.comparingDouble(SeriesModel::getRating)).orElse(null);
    }

    public ArrayList<SeriesModel> filterByGenreList(String genre) {
        ArrayList<SeriesModel> result = new ArrayList<>();
        for (SeriesModel s : seriesList) {
            if (s.getGenre().equalsIgnoreCase(genre)) {
                result.add(s);
            }
        }
        return result;
    }

    public long countSeriesAvailableForAge(int age) {
        return seriesList.stream().filter(s -> s.isAgeAppropriate(age)).count();
    }

    public void sortSeriesByName() {
        seriesList.sort(Comparator.comparing(SeriesModel::getSeriesName));
            System.out.println("Series sorted by name:");
        seriesList.forEach(s -> System.out.println(s.getSeriesSummary()));
    }

    public void filterByGenre(String genre) {
        List<SeriesModel> filtered = seriesList.stream()
                                           .filter(s -> s.getGenre().equalsIgnoreCase(genre))
                                           .toList();
        if (filtered.isEmpty()) {
            System.out.println("No series found for genre: " + genre);
        } else {
            filtered.forEach(s -> System.out.println(s.getSeriesSummary()));
        }
    }

    public void topRatedSeries() {
        SeriesModel topRated = seriesList.stream()
                                     .max(Comparator.comparingDouble(SeriesModel::getRating))
                                     .orElse(null);
        if (topRated != null) {
            System.out.println("Top Rated Series:");
            System.out.println(topRated.getSeriesSummary());
        } else {
            System.out.println("No series available to determine top rated.");
        }
    }

    public void countSeriesForAge(int age) {
        long count = seriesList.stream().filter(s -> s.isAgeAppropriate(age)).count();
        System.out.println("Number of series suitable for age " + age + ": " + count);
    }

    public void countSeriesByAge(int age) {
        long count = seriesList.stream()
                           .filter(s -> s.getSeriesAge() <= age)
                           .count();

            System.out.println("Number of series suitable for age " + age + ": " + count);
    }
}


