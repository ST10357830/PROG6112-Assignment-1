/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Khwinana Kabelo Makibelo 
 */

public class DocumentarySeries extends SeriesModel {
    private String narrator;

    public DocumentarySeries(int seriesId, String seriesName, String genre, int episodes,
                             double rating, int releaseYear, int ageRestriction, String narrator) {
        super(seriesId, seriesName, genre, episodes, rating, releaseYear, ageRestriction);
        this.narrator = narrator;
    }

    public String getNarrator() { return narrator; }
    public void setNarrator(String narrator) { this.narrator = narrator; }

    @Override
    public String getSeriesSummary() {
        return super.getSeriesSummary() + ", Narrator: " + narrator;
    }
}
