package prog6112.assignment;

import java.util.*;

public class PROG6112Assignment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Series> mySeries = new ArrayList<>();

        // Declarations
        byte choice = 0;
        String start;

        // Start-up Menu
        System.out.println("Latest Series - 2025");
        System.out.println("*".repeat(30) + "\n");
        System.out.print("Enter (1) to launch menu or any key to exit: ");
        start = scanner.nextLine();
        
        if (start.equals("1")) {
            System.out.println("Application Opened");
        } else {
            System.out.println("Application Closing. Goodbye");
            System.exit(0);
        }

        while (true) {

            // Main Menu
            System.out.println("\n--- Main Menu ---");
            System.out.println("Please select one of the following menu items: ");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");

            System.out.print("\n>> ");
            choice = scanner.nextByte();
            
            switch (choice) {
                case 1:
                    Series newSeries = Series.captureSeries(scanner);
                    mySeries.add(newSeries);
                    break;
                case 2:
                    Series.searchSeries(mySeries, scanner);
                    break;
                case 3:
                    Series.updateSeries(mySeries, scanner);
                    break;
                case 4:
                    Series.deleteSeries(mySeries, scanner);
                    break;
                case 5:
                    Series.seriesReport(mySeries, scanner);
                    break;
                case 6:
                    Series.exitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid input!!!");
            }
        }
    }
}
