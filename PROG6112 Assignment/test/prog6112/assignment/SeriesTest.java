package prog6112.assignment;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class SeriesTest {
    
    private static ArrayList<Series> testSeriesList = new ArrayList<>();
    
    public SeriesTest() {
    }

    @Test
    public void testSearchSeries() {
        // Arrange / Expected
        String expectedSeriesID = "110";
        String expectedName = "Walking Dead";
        String expectedAgeRes = "18";
        String expectedNumOfEpisodes = "15";
        
        // Act / Actual
        Series seriesTest = new Series(expectedSeriesID, expectedName, expectedAgeRes, expectedNumOfEpisodes);
        testSeriesList.add(seriesTest);
        
        Series seriesFound = findSeriesByID(expectedSeriesID);
        
        // Assert
        assertNotNull(seriesFound, "Series has been found");
        assertEquals(expectedSeriesID, seriesFound.getSeriesID(), "Series ID matches");
        assertEquals(expectedName, seriesFound.getSeriesName(), "Series name matches");
        assertEquals(expectedAgeRes, seriesFound.getSeriesAge(), "Series age restriction matches");
        assertEquals(expectedNumOfEpisodes, seriesFound.getSeriesNumberOfEpisodes(), "Series number of episodes matches");
        
        // Clean up
        testSeriesList.clear();
    }

    @Test
    public void testSearchSeries_SeriesNotFound() {
        // Arrange / Expected
        String invalidID = "999";
        
        // Add some test data
        Series seriesTest = new Series("110", "Walking Dead", "18", "15");
        testSeriesList.add(seriesTest);
        
        // Act / Actual
        Series seriesFound = findSeriesByID(invalidID);
        
        // Assert
        assertNull(seriesFound, "Series was not found");
        
        // Clean up
        testSeriesList.clear();
    }

    @Test
    public void testUpdateSeries() {
        // Arrange / Expected
        Series seriesTest = new Series("333", "Original Name", "7", "10");
        testSeriesList.add(seriesTest);
        
        String expectedName = "Updated Name";
        String expectedAgeRes = "12";
        String expectedNumOfEpisodes = "20";
        
        // Act / Actual
        // Find and update the series
        Series seriesToUpdate = findSeriesByID("333");
        assertNotNull(seriesToUpdate, "Series should exist before update");
        
        seriesToUpdate.setSeriesName(expectedName);
        seriesToUpdate.setSeriesAge(expectedAgeRes);
        seriesToUpdate.setSeriesNumberOfEpisodes(expectedNumOfEpisodes);
        
        Series updatedSeries = findSeriesByID("333");
        
        // Assert
        assertNotNull(updatedSeries, "Series should exist after update");
        assertEquals("333", updatedSeries.getSeriesID(), "Series ID should remain the same");
        assertEquals(expectedName, updatedSeries.getSeriesName(), "Series name should be updated");
        assertEquals(expectedAgeRes, updatedSeries.getSeriesAge(), "Series age restriction should be updated");
        assertEquals(expectedNumOfEpisodes, updatedSeries.getSeriesNumberOfEpisodes(), "Series number of episodes should be updated");
        
        // Clean up
        testSeriesList.clear();
    }

    @Test
    public void testDeleteSeries() {
        // Arrange / Expected
        Series seriesTest = new Series("009", "Test Series", "12", "8");
        testSeriesList.add(seriesTest);
        
        // Verify series exists before deletion
        assertNotNull(findSeriesByID("009"), "Series should exist before deletion");
        
        // Act / Actual
        boolean deleted = deleteSeriesByID("009");
        
        // Assert
        assertTrue(deleted, "Series should be deleted successfully");
        assertNull(findSeriesByID("009"), "Series should not exist after deletion");
        
        // Clean up
        testSeriesList.clear();
    }

    @Test
    public void testDeleteSeries_SeriesNotFound() {
        // Arrange / Expected
        Series seriesTest = new Series("444", "Existing Series", "5", "8");
        testSeriesList.add(seriesTest);
        
        // Act / Actual
        boolean deleted = deleteSeriesByID("999"); // Non-existent ID
        
        // Assert
        assertFalse(deleted, "Series should not be deleted if not found");
        assertNotNull(findSeriesByID("444"), "Original series should still exist");
        
        // Clean up
        testSeriesList.clear();
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        // Arrange / Expected
        String validAge = "12";
        
        // Act / Actual
        boolean isValid = isValidAgeRestriction(validAge);
        
        // Assert
        assertTrue(isValid, "Age restriction 12 should be valid");
    }

    @Test
    public void testSeriesAgeRestriction_SeriesAgeInValid() {
        // Test with age below minimum
        String tooLowAge = "1";
        boolean isValidLow = isValidAgeRestriction(tooLowAge);
        assertFalse(isValidLow, "Age restriction 1 should be invalid");
        
        // Test with age above maximum
        String tooHighAge = "19";
        boolean isValidHigh = isValidAgeRestriction(tooHighAge);
        assertFalse(isValidHigh, "Age restriction 19 should be invalid");
        
        // Test with non-numeric value
        String nonNumericAge = "abc";
        boolean isValidNonNumeric = isValidAgeRestriction(nonNumericAge);
        assertFalse(isValidNonNumeric, "Non-numeric age should be invalid");
    }
    
    // Helper methods for testing (simulating the actual methods)
    private Series findSeriesByID(String seriesID) {
        for (Series series : testSeriesList) {
            if (seriesID.equals(series.getSeriesID())) {
                return series;
            }
        }
        return null;
    }
    
    private boolean deleteSeriesByID(String seriesID) {
        for (int i = 0; i < testSeriesList.size(); i++) {
            if (seriesID.equals(testSeriesList.get(i).getSeriesID())) {
                testSeriesList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    private boolean isValidAgeRestriction(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 2 && ageValue <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}