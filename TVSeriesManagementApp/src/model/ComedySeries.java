/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Khwinana Kabelo Makibelo 
 */

public class ComedySeries extends SeriesModel {
    private String comedian;

    public ComedySeries(int seriesId, String seriesName, String genre, int episodes,
                        double rating, int releaseYear, int ageRestriction, String comedian) {
        super(seriesId, seriesName, genre, episodes, rating, releaseYear, ageRestriction);
        this.comedian = comedian;
    }

    public String getComedian() { return comedian; }
    public void setComedian(String comedian) { this.comedian = comedian; }

    @Override
    public String getSeriesSummary() {
        return super.getSeriesSummary() + ", Starring Comedian: " + comedian;
    }
}

