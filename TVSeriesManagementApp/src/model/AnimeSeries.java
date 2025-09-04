/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

public class AnimeSeries extends SeriesModel {
    private String studio;

    public AnimeSeries(int seriesId, String seriesName, String genre, int episodes,
                       double rating, int releaseYear, int ageRestriction, String studio) {
        super(seriesId, seriesName, genre, episodes, rating, releaseYear, ageRestriction);
        this.studio = studio;
    }

    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }

    @Override
    public String getSeriesSummary() {
        return super.getSeriesSummary() + ", Studio: " + studio;
    }
}

