package prog6112.section.b;

import java.util.*;

public class Student {

    // Declaration
    private String firstName, lastName, phoneNum, studentID;

    // Default Constructor
    public Student() {
    }

    // Overloaded Constructor
    public Student(String firstName, String lastName, String phoneNum, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.studentID = studentID;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getStudentID() {
        return studentID;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    // Method to auto generate StudentID
    public static String generateStudentID() {
        Random random = new Random();
        StringBuilder studentID = new StringBuilder();

        // Generate 8 random digits
        for (int i = 0; i < 8; i++) {
            studentID.append(random.nextInt(10)); // Random digit 0-9
        }

        return studentID.toString();
    }

    // Method to capture student information
    public static Student captureStudentInfo(Scanner scanner) {

        scanner.nextLine();     // consume leftover new line.

        // Declaration
        String firstName, lastName, phoneNum, studentID;

        System.out.print("Enter student's first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter student's surname: ");
        lastName = scanner.nextLine();

        studentID = generateStudentID();        // auto generates an 8 digit Student ID
        System.out.println("Assigned Student ID: " + studentID);

        System.out.print("Enter student's phone number: ");
        phoneNum = scanner.nextLine();

        while (!phoneNum.startsWith("0") || phoneNum.length() != 10) {
            System.out.println("Phone number is incorrectly formatted");
            System.out.println("e.g \"0123456789\" \n");
            System.out.print("Please re-enter phone number: ");
            phoneNum = scanner.nextLine();
        }
        System.out.println("Phone number has successfully been captured.");

        System.out.println("Student Profile has been captured!");

        Student students = new Student(firstName, lastName, phoneNum, studentID);

        return students;
    }

    // Method to capture student with results
    public static StudentWithResults captureStudentWithResults(Scanner scanner) {
        scanner.nextLine();     // consume leftover new line

        // Declaration
        String firstName, lastName, phoneNum, studentID;

        System.out.print("Enter student's first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter student's surname: ");
        lastName = scanner.nextLine();

        studentID = generateStudentID();        // auto generates an 8 digit Student ID
        System.out.println("Assigned Student ID: " + studentID);

        System.out.print("Enter student's phone number: ");
        phoneNum = scanner.nextLine();

        while (!phoneNum.startsWith("0") || phoneNum.length() != 10) {
            System.out.println("Phone number is incorrectly formatted");
            System.out.println("e.g \"0123456789\" \n");
            System.out.print("Please re-enter phone number: ");
            phoneNum = scanner.nextLine();
        }
        System.out.println("Phone number has successfully been captured.");

        StudentWithResults student = new StudentWithResults(firstName, lastName, phoneNum, studentID);

        // Capture results
        student.captureResults(scanner);

        System.out.println("Student Profile with Results has been captured!");

        return student;
    }

    // Method to search & display student profile
    public static void searchProfile(ArrayList<Student> myStudent, Scanner scanner) {

        // Declarations
        String searchID;
        boolean searchFound = false;

        scanner.nextLine();  // ask sir about this

        System.out.println("*".repeat(30));
        System.out.println("\n--- Search Student Profile ---\n");
        System.out.print("Enter Student ID to search: ");
        searchID = scanner.nextLine();
        System.out.println("-".repeat(30));

        for (Student students : myStudent) {
            if (searchID.equals(students.getStudentID())) {

                System.out.println("Student ID: " + students.getStudentID());
                System.out.println("Student Name: " + students.getFirstName());
                System.out.println("Student Surname: " + students.getLastName());
                System.out.println("Student phone number: " + students.getPhoneNum());

                // Display results if available
                if (students instanceof StudentWithResults) {
                    ((StudentWithResults) students).displayResults();
                }

                searchFound = true;
                break;
            }
        }
        if (!searchFound) {
            System.out.println("Student with an ID of: " + searchID + " was not found");
        }
        System.out.println("-".repeat(30));
    }

    // Method to display all registered students
    public static void studentRegister(ArrayList<Student> myStudent, Scanner scanner) {
        System.out.println("*".repeat(30));
        System.out.println("\n--- Student Register ---");
        System.out.println("-".repeat(30));

        if (myStudent.isEmpty()) {
            System.out.println("No students registered yet.");
            System.out.println("-".repeat(30));
            return;
        }

        for (int j = 0; j < myStudent.size(); j++) {
            Student students = myStudent.get(j);

            System.out.println(" Student " + (j + 1));
            System.out.println("Student ID: " + students.getStudentID());
            System.out.println("Student First Name: " + students.getFirstName());
            System.out.println("Student Surname: " + students.getLastName());
            System.out.println("Student Phone Number: " + students.getPhoneNum());

            if (students instanceof StudentWithResults) {
                ((StudentWithResults) students).displayResults();
            }

            System.out.println("-".repeat(30));
        }
    }

    // Method to update student information
    public static void updateStudentInfo(ArrayList<Student> myStudent, Scanner scanner) {
        scanner.nextLine();

        // Declaration
        String studentID, firstName, lastName, phoneNum;
        boolean studentFound = false;

        System.out.println("*".repeat(30));
        System.out.println("--- Update Student Info ---");
        System.out.print("Enter student ID to search: ");
        studentID = scanner.nextLine();
        System.out.println("-".repeat(30));

        for (Student student : myStudent) {
            if (studentID.equals(student.getStudentID())) {
                studentFound = true;

                System.out.print("Enter student's new first name: ");
                firstName = scanner.nextLine();
                student.setFirstName(firstName);

                System.out.print("Enter student's new last name: ");
                lastName = scanner.nextLine();
                student.setLastName(lastName);

                System.out.print("Enter student's new phone number: ");
                phoneNum = scanner.nextLine();

                // Validate phone number
                while (!phoneNum.startsWith("0") || phoneNum.length() != 10) {
                    System.out.println("Phone number is incorrectly formatted");
                    System.out.println("e.g \"0123456789\" \n");
                    System.out.print("Please re-enter phone number: ");
                    phoneNum = scanner.nextLine();
                }
                student.setPhoneNum(phoneNum);

                System.out.println("Student information updated successfully!");
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student with ID " + studentID + " was not found.");
        }
    }

    // Method to add or update results
    public static void addOrUpdateResults(ArrayList<Student> myStudent, Scanner scanner) {
    scanner.nextLine();

    System.out.println("*".repeat(30));
    System.out.println("\n--- Add or Update Results ---");
    System.out.print("Enter student ID: ");
    String studentID = scanner.nextLine();

    boolean studentFound = false;

    for (int i = 0; i < myStudent.size(); i++) {
        Student student = myStudent.get(i);

        if (studentID.equals(student.getStudentID())) {
            studentFound = true;
            try {
                StudentWithResults studentWithResults = (StudentWithResults) student;
                studentWithResults.captureResults(scanner);
                System.out.println("Results updated successfully!");
            } 
            catch (ClassCastException e) {
                StudentWithResults studentWithResults = new StudentWithResults(student.getFirstName(), student.getLastName(), student.getPhoneNum(), student.getStudentID());
                studentWithResults.captureResults(scanner);
                myStudent.set(i, studentWithResults);
                System.out.println("Results added successfully!");
            }
            
            break;
        }
    }

    if (!studentFound) {
        System.out.println("Student with ID " + studentID + " was not found.");
    }
}

    // Method to delete student profile
    public static void deleteProfile(ArrayList<Student> myStudent, Scanner scanner) {

        scanner.nextLine();

        // Declaration
        String deleteProfile, confirm;
        boolean idFound = false;

        System.out.println("*".repeat(30));
        System.out.println("\n--- Delete Student Profile ---");

        System.out.print("Enter student ID: ");
        deleteProfile = scanner.nextLine();

        // Find Student ID
        for (int i = 0; i < myStudent.size(); i++) {
            if (deleteProfile.equals(myStudent.get(i).getStudentID())) {
                idFound = true;
                break;
            }
        }
        // Display if not found
        if (!idFound) {
            System.out.println("This Student ID " + deleteProfile + " was not found");
            return;     // exit method early
        }

        System.out.println("Deleting Student " + deleteProfile);
        System.out.print("Yes (y) to delete or No (n) to cancel: ");
        confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            for (int a = 0; a < myStudent.size(); a++) {
                if (deleteProfile.equals(myStudent.get(a).getStudentID())) {  // Fixed: use deleteProfile instead of confirm
                    System.out.println("Student " + deleteProfile + " was deleted!");
                    myStudent.remove(a);
                    break;
                }
            }
        } else if (confirm.equalsIgnoreCase("n")) {
            System.out.println("Deletion cancelled");
        }
    }

    // Method to close application
    public static void closeSystem() {
        System.out.println("Closing Application");
        System.exit(0);
    }
}
