package prog6112.section.b;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    
    public StudentTest() {
    }

    @Test
    public void testStudentConstructorStoresInformationCorrectly() {
        // Arrange
        String firstName = "John";
        String lastName = "Doe";
        String phoneNum = "0123456789";
        String studentID = "12345678";
        
        // Act
        Student student = new Student(firstName, lastName, phoneNum, studentID);
        
        // Assert
        assertEquals(firstName, student.getFirstName());
        assertEquals(lastName, student.getLastName());
        assertEquals(phoneNum, student.getPhoneNum());
        assertEquals(studentID, student.getStudentID());
    }

    @Test
    public void testStudentSettersChangeInformation() {
        // Arrange
        Student student = new Student();
        
        // Act
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setPhoneNum("0987654321");
        
        // Assert
        assertEquals("Jane", student.getFirstName());
        assertEquals("Smith", student.getLastName());
        assertEquals("0987654321", student.getPhoneNum());
    }

    @Test
    public void testStudentWithResultsHasSubjectAndMarkArrays() {
        // Arrange & Act
        StudentWithResults student = new StudentWithResults("Test", "Student", "0123456789", "12345678");
        
        // Assert
        assertNotNull(student.getSubjects());
        assertNotNull(student.getMarks());
        assertEquals(3, student.getSubjects().length);
        assertEquals(3, student.getMarks().length);
    }

    @Test
    public void testPhoneNumberValidationRules() {
        // Arrange
        String goodPhone = "0123456789";
        String badStart = "1123456789";
        String tooShort = "012345678";
        
        // Act
        boolean goodResult = goodPhone.startsWith("0") && goodPhone.length() == 10;
        boolean badStartResult = badStart.startsWith("0") && badStart.length() == 10;
        boolean tooShortResult = tooShort.startsWith("0") && tooShort.length() == 10;
        
        // Assert
        assertTrue(goodResult);
        assertFalse(badStartResult);
        assertFalse(tooShortResult);
    }

    @Test
    public void testEmptyStudentConstructor() {
        // Arrange & Act
        Student student = new Student();
        
        // Assert
        assertNotNull(student);
        assertNull(student.getFirstName());
        assertNull(student.getLastName());
        assertNull(student.getPhoneNum());
        assertNull(student.getStudentID());
    }

    @Test
    public void testStudentWithResultsConstructor() {
        // Arrange
        String firstName = "Bob";
        String lastName = "Brown";
        String phoneNum = "0123456789";
        String studentID = "11111111";
        
        // Act
        StudentWithResults student = new StudentWithResults(firstName, lastName, phoneNum, studentID);
        
        // Assert
        assertEquals(firstName, student.getFirstName());
        assertEquals(lastName, student.getLastName());
        assertEquals(phoneNum, student.getPhoneNum());
        assertEquals(studentID, student.getStudentID());
        assertNotNull(student.getSubjects());
        assertNotNull(student.getMarks());
    }
}