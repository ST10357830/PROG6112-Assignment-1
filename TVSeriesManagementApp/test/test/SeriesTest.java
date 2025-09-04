/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Khwinana Kabelo Makibelo
 */
import app.SeriesApp;
import model.SeriesModel;
import service.Series;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SeriesTest {

    private Series seriesService;

    @Before
    public void setUp() {
        seriesService = new Series();

        // Preload with sample series
        seriesService.seriesList = new ArrayList<>(); // (Make seriesList public for testing OR add getter)
        seriesService.seriesList.add(new SeriesModel(101, "Extreme Sports", "Sports", 10, 8.0, 2015, 12));
        seriesService.seriesList.add(new SeriesModel(102, "Bargain Hunters", "Reality", 8, 7.5, 2018, 10));
    }

    @Test
    public void testSearchSeries_Found() {
        SeriesModel found = seriesService.findSeriesById(101);
        assertNotNull(found);
        assertEquals("Extreme Sports", found.getSeriesName());
    }

    @Test
    public void testSearchSeries_NotFound() {
        SeriesModel found = seriesService.findSeriesById(999);
        assertNull(found);
    }

    @Test
    public void testUpdateSeries() {
        SeriesModel series = seriesService.findSeriesById(101);
        assertNotNull(series);
        series.setAgeRestriction(15);
        assertEquals(15, series.getAgeRestriction());
    }

    @Test
    public void testDeleteSeries_Found() {
        boolean deleted = seriesService.deleteSeriesById(101);
        assertTrue(deleted);
        assertNull(seriesService.findSeriesById(101));
    }

    @Test
    public void testDeleteSeries_NotFound() {
        boolean deleted = seriesService.deleteSeriesById(999);
        assertFalse(deleted);
    }

    @Test
    public void testSeriesAgeRestriction_Valid() {
        SeriesModel series = seriesService.findSeriesById(102);
        assertTrue(series.isAgeAppropriate(15)); // Viewer 15 can watch age 10+
    }

    @Test
    public void testSeriesAgeRestriction_Invalid() {
        SeriesModel series = seriesService.findSeriesById(102);
        assertFalse(series.isAgeAppropriate(8)); // Viewer 8 < required 10
    }

    // BONUS FEATURE TESTS

    @Test
    public void testTopRatedSeries() {
        SeriesModel top = seriesService.getTopRated();
        assertEquals("Extreme Sports", top.getSeriesName()); // rating 8.0 vs 7.5
    }

    @Test
    public void testSortSeriesByName() {
        seriesService.sortSeriesByName();
        assertEquals("Bargain Hunters", seriesService.seriesList.get(0).getSeriesName());
    }

    @Test
    public void testFilterByGenre() {
        ArrayList<SeriesModel> filtered = seriesService.filterByGenreList("Sports");
        assertEquals(1, filtered.size());
        assertEquals("Extreme Sports", filtered.get(0).getSeriesName());
    }

    @Test
    public void testCountSeriesByAge() {
        long count = seriesService.countSeriesAvailableForAge(12);
        assertEquals(2, count); // both available at age 12+
    }
    
    @Test
public void TestSimulatedInput() {
    String simulatedInput = "2\nBreaking Bad\nDrama\n62\n9.5\n18\n"; 
    ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
    System.setIn(in);
    SeriesApp.main(new String[]{});
}

}


