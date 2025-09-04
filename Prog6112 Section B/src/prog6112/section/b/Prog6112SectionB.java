package prog6112.section.b;
import java.util.*;

public class Prog6112SectionB {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> myStudent = new ArrayList<>();
        
        // Declaration
        String start;
        byte option;
        
        // Start-up Menu
        System.out.println(" Welcome to The Institute of Loop Learning ");
        System.out.println("-".repeat(42) + "\n");
        System.out.println("Press (1) to proceed or press any key to close the application");
        System.out.print(">> ");
        start = scanner.nextLine();
        
        if (start.equals("1")) {
        } else {
            System.out.println("Goodbye! Till we while (true) { meet.again(); }");
            System.exit(0);
        }
        
        while (true) {
            // Main Menu
            System.out.println("\nThe Institution of Loop Learning");
            
            System.out.println("-".repeat(32));
            System.out.println(" --- THE ITERATION STATION ---");
            System.out.println("       Student Management");
            System.out.println("-".repeat(32));
            
            System.out.println("(1) Create Student Profile");
            System.out.println("(2) Create Student Profile with Results");
            System.out.println("(3) Search & Display Student Profile");
            System.out.println("(4) Display All Student Profiles");
            System.out.println("(5) Update Student Information");
            System.out.println("(6) Add or Update Results for Students");
            System.out.println("(7) Delete Student Information");
            System.out.println("(8) Close Application");
            System.out.print(">> ");
            option = scanner.nextByte();
            
            switch (option) {
                case 1:
                    Student newStudent = Student.captureStudentInfo(scanner);
                    myStudent.add(newStudent);
                    break;
                case 2:
                    Student newStudentWithResults = Student.captureStudentWithResults(scanner);
                    myStudent.add(newStudentWithResults);
                    break;
                case 3:
                    Student.searchProfile(myStudent, scanner);
                    break;
                case 4:
                    Student.studentRegister(myStudent, scanner);
                    break;
                case 5:
                    Student.updateStudentInfo(myStudent, scanner);
                    break;
                case 6:
                    Student.addOrUpdateResults(myStudent, scanner);
                    break;
                case 7:
                    Student.deleteProfile(myStudent, scanner);
                    break;
                case 8:
                    Student.closeSystem();
                    break;
            }
        }
    }
}