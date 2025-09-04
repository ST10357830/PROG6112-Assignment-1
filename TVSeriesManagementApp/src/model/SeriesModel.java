/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

public class SeriesModel {
    // Fields (information hiding)
    private int seriesId;
    private String seriesName;
    private String genre;
    private int episodes;
    private double rating;
    private int releaseYear;
    private int ageRestriction;
    private int seriesAge;     
    private int seriesNumberOfEpisodes;

    // Constructor
    public SeriesModel(int seriesId, String seriesName, String genre, int episodes,
                       double rating, int releaseYear, int ageRestriction) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.genre = genre;
        this.episodes = episodes;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.ageRestriction = ageRestriction;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Getters and Setters
    public int getSeriesId() { return seriesId; }
    public void setSeriesId(int seriesId) { this.seriesId = seriesId; }

    public String getSeriesName() { return seriesName; }
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getEpisodes() { return episodes; }
    public void setEpisodes(int episodes) { this.episodes = episodes; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public int getAgeRestriction() { return ageRestriction; }
    public void setAgeRestriction(int ageRestriction) { this.ageRestriction = ageRestriction; }

    public int getSeriesAge() {return seriesAge;}
    public void setSeriesAge(int seriesAge) { this.seriesAge = seriesAge;}
    
    public int getSeriesNumberOfEpisodes() {return seriesNumberOfEpisodes;}
    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) { this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; }
    
    // Helper methods
    public boolean isAgeAppropriate(int viewerAge) {
        return viewerAge >= ageRestriction;
    }

    public String getSeriesSummary() {
        return "ID: " + seriesId + ", Title: " + seriesName +
               ", Genre: " + genre + ", Episodes: " + episodes +
               ", Rating: " + rating + "/10, Year: " + releaseYear +
               ", Age Restriction: " + ageRestriction + "+";
    }
}


