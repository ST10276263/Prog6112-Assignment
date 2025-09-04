package prog6112.section.b;
import java.util.*;

public class StudentWithResults extends Student {
    
    // Declarations - using arrays as required
    public String[] subjects;
    public int[] marks;

    // Default Constructor
    public StudentWithResults(String firstName, String lastName, String phoneNum, String studentID) {
        super(firstName, lastName, phoneNum, studentID);
        this.subjects = new String[3];
        this.marks = new int[3];
    }

    // Overloaded Constructor
    public StudentWithResults(String[] subjects, int[] marks, String firstName, String lastName, String phoneNum, String studentID) {
        super(firstName, lastName, phoneNum, studentID);
        this.subjects = subjects;
        this.marks = marks;
    }
    
    // Method to capture results
    public void captureResults(Scanner scanner) {
        System.out.println("\n--- Enter Student Results ---");
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter subject " + (i+1) + " name: ");
            subjects[i] = scanner.nextLine();
            
            System.out.print("Enter mark for " + subjects[i] + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            // Validate mark
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid mark! Please enter a value between 0-100.");
                System.out.print("Enter mark for " + subjects[i] + ": ");
                marks[i] = scanner.nextInt();
                scanner.nextLine();
            }
        }
        System.out.println("Results captured successfully!");
    }

    // Method to display results
    public void displayResults() {
        System.out.println("\n--- Academic Results ---");
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        
        for (int i = 0; i < 3; i++) {
            System.out.println(subjects[i] + ": " + marks[i] + "%");
        }
        System.out.println("Average: " + calculateAverage() + "%");
    }
    
    // Method to calculate average
    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / 3.0;
    }
    
    // Getters for the arrays
    public String[] getSubjects() {
        return subjects;
    }
    
    public int[] getMarks() {
        return marks;
    }
}