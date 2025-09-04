package prog6112.assignment;

import java.util.*;

public class Series {

    public String seriesID, seriesName, seriesNumberOfEpisodes, seriesAge;

    // Constructor
    public Series(String seriesID, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        this.seriesID = seriesID;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Setters
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setSeriesAge(String seriesAge) {
        this.seriesAge = seriesAge;
    }

    public void setSeriesNumberOfEpisodes(String seriesNumberOfEpisodes) {
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Getters
    public String getSeriesID() {
        return seriesID;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public String getSeriesAge() {
        return seriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    // Method to capture a new Series
    public static Series captureSeries(Scanner scanner) {

        // Declarations
        String seriesID, seriesName, seriesNumberOfEpisodes, seriesAge;

        System.out.println("*".repeat(30));
        System.out.println("\n--- Capture Series ---");

        scanner.nextLine();     // Consume leftover newline from previous input

        System.out.print("Enter series id: ");
        seriesID = scanner.nextLine();

        System.out.print("Enter series name: ");
        seriesName = scanner.nextLine();

        System.out.print("Enter the series age restriction: ");
        seriesAge = scanner.nextLine();

        while (true) {

            // Logic for age restriction (2 - 18)
            try {                                      // tests for errors whilst code is running     
                if (Integer.parseInt(seriesAge) >= 2 && Integer.parseInt(seriesAge) <= 18) {        // correct age, proceeds to the next
                    break;
                } else {
                    System.out.print("Please re-enter the series age (2 - 18) >> ");
                    seriesAge = scanner.nextLine();
                }
            } catch (NumberFormatException e) {       // if an error is detected in the "try block", this will handle the errors
                System.out.print("Please re-enter the series age (2 - 18) >> ");
                seriesAge = scanner.nextLine();
            }
        }

        System.out.print("Enter the number of episodes for " + seriesName + ": ");
        seriesNumberOfEpisodes = scanner.nextLine();

        System.out.println("Series processed successfully!!!");

        Series series = new Series(seriesID, seriesName, seriesAge, seriesNumberOfEpisodes);

        return series;
    }

    // Method to search for a series
    public static void searchSeries(ArrayList<Series> mySeries, Scanner scanner) {

        // Declaration
        String searchSeriesID;
        boolean seriesFound = false;

        scanner.nextLine();
        System.out.println("*".repeat(30));
        System.out.println("\n--- Search Series ---\n");
        System.out.print("Enter the series id to search: ");
        searchSeriesID = scanner.nextLine();
        System.out.println("-".repeat(30));

        for (Series series : mySeries) {
            if (searchSeriesID.equals(series.getSeriesID())) {

                System.out.println("SERIES ID: " + series.getSeriesID());
                System.out.println("SERIES NAME: " + series.getSeriesName());
                System.out.println("SERIES AGE RESTRICTION: " + series.getSeriesAge());
                System.out.println("SERIES NUMBER OF EPISODES: " + series.getSeriesNumberOfEpisodes());

                seriesFound = true;
                break;                                      // exits the loop once the series has been found
            }
        }
        if (!seriesFound) {
            System.out.println("Series with Series ID: " + searchSeriesID + " was not found!");
        }
        System.out.println("-".repeat(30));
    }

    // Method to update series information
    public static void updateSeries(ArrayList<Series> mySeries, Scanner scanner) {
        String searchSeriesID, seriesName, seriesNumberOfEpisodes, seriesAge;

        scanner.nextLine();

        System.out.println("*".repeat(30));
        System.out.println("--- Update Series ---");
        System.out.print("Enter the series id to search: ");
        searchSeriesID = scanner.nextLine();
        System.out.println("-".repeat(30));

        for (Series series : mySeries) {
            if (searchSeriesID.equals(series.getSeriesID())) {

                System.out.print("Enter series name: ");
                seriesName = scanner.nextLine();
                if (!seriesName.isEmpty()) {
                    series.setSeriesName(seriesName);
                }

                System.out.print("Enter the series age restriction: ");
                seriesAge = scanner.nextLine();
                if (!seriesAge.isEmpty()) {
                    while (true) {
                        try {
                            if (Integer.parseInt(seriesAge) >= 2 && Integer.parseInt(seriesAge) <= 18) {
                                series.setSeriesAge(seriesAge);
                                break;
                            } else {
                                System.out.print("Please re-enter the series age (2 - 18) >> ");
                                seriesAge = scanner.nextLine();
                            }
                        } catch (NumberFormatException e) {
                            System.out.print("Please re-enter the series age (2 - 18) >> ");
                            seriesAge = scanner.nextLine();
                        }
                    }
                }

                System.out.print("Enter the number of episodes for " + series.getSeriesName() + ": ");
                seriesNumberOfEpisodes = scanner.nextLine();
                if (!seriesNumberOfEpisodes.isEmpty()) {
                    series.setSeriesNumberOfEpisodes(seriesNumberOfEpisodes);
                }

                System.out.println("Series updated successfully!");
                return;
            }
        }

        System.out.println("Series with ID '" + searchSeriesID + "' not found!");
    }

    // Method to delete a series
    public static void deleteSeries(ArrayList<Series> mySeries, Scanner scanner) {

        // Declaration
        String deletingSeries;
        boolean seriesFound = false;

        scanner.nextLine();

        System.out.println("*".repeat(30));
        System.out.println("\n--- Delete Series ---");

        System.out.print("Enter series id to delete: ");
        deletingSeries = scanner.nextLine();

        // First check if the series exists
        for (int i = 0; i < mySeries.size(); i++) {
            if (deletingSeries.equals(mySeries.get(i).getSeriesID())) {
                seriesFound = true;
                break;
            }
        }

        if (!seriesFound) {
            System.out.println("Series with Series ID: " + deletingSeries + " was not found!");
            return;
        }

        // Only ask to confirmation if the series exists
        System.out.println("Are you sure you want to delete series " + deletingSeries + " from the system? Yes (y) to delete or No (n) to cancel.");
        System.out.print(">> ");
        String confirmDelete = scanner.nextLine();

        if (confirmDelete.equalsIgnoreCase("y")) {
            for (int i = 0; i < mySeries.size(); i++) {
                if (deletingSeries.equals(mySeries.get(i).getSeriesID())) {
                    System.out.println("Series with Series ID: " + deletingSeries + " was deleted!");
                    mySeries.remove(i);
                    break;
                }
            }
        } else if (confirmDelete.equalsIgnoreCase("n")) {
            System.out.println("Cancelling deletion");
        }
    }

    // Method to display all series that have been stored
    public static void seriesReport(ArrayList<Series> mySeries, Scanner scanner) {

        System.out.println("*".repeat(30));
        System.out.println("\n--- Series Report ---");
        System.out.println("-".repeat(30));

        if (mySeries.isEmpty()) {
            System.out.println("No series found!");
            System.out.println("-".repeat(30));
        }

        for (int a = 0; a < mySeries.size(); a++) {
            Series series = mySeries.get(a);
            System.out.println(" Series " + (a + 1));
            System.out.println("SERIES ID: " + series.getSeriesID());
            System.out.println("SERIES NAME: " + series.getSeriesName());
            System.out.println("SERIES AGE RESTRICTION: " + series.getSeriesAge());
            System.out.println("SERIES NUMBER OF EPISODES: " + series.getSeriesNumberOfEpisodes());
            System.out.println("-".repeat(30));
        }
    }

    // Method to exit application
    public static void exitSeriesApplication() {
        System.out.println("Closing Application.\n"
                + "Goodbye!!!");
        System.exit(0);
    }
}
