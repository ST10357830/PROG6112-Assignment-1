/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */

public class DramaSeries extends SeriesModel {
    private String leadActor;

    public DramaSeries(int seriesId, String seriesName, String genre, int episodes,
                       double rating, int releaseYear, int ageRestriction, String leadActor) {
        super(seriesId, seriesName, genre, episodes, rating, releaseYear, ageRestriction);
        this.leadActor = leadActor;
    }

    public String getLeadActor() { return leadActor; }
    public void setLeadActor(String leadActor) { this.leadActor = leadActor; }

    @Override
    public String getSeriesSummary() {
        return super.getSeriesSummary() + ", Lead Actor: " + leadActor;
    }
}
