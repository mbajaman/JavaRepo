import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    ArrayList<String> choices = new ArrayList<>();

    Student stu = new Student("A00123456", "Roy", "Li", 1, "", choices);

    @org.junit.Test
    public void getID() throws Exception {

        assertEquals("A00123456", stu.getID());
    }

    @org.junit.Test
    public void getFirstName() throws Exception {

        assertEquals("Roy", stu.getFirstName());
    }

    @org.junit.Test
    public void getLastName() throws Exception {

        assertEquals("Li", stu.getLastName());
    }

    @org.junit.Test
    public void getName() throws Exception {

        assertEquals("Roy Li", stu.getName());
    }

    @org.junit.Test
    public void getPriority() throws Exception {

        assertEquals(1, stu.getPriority());
    }

    @org.junit.Test
    public void getGPA() throws Exception {

        assertEquals(0, stu.getGPA(),0);
    }

    @org.junit.Test
    public void getStudentChoices() throws Exception {
        choices.add("Web Develoment");
        choices.add("Cyber Security");
        choices.add("Java Programming");
        choices.add("UI/UX Design");

        assertTrue(choices.equals(stu.getStudentChoices()));
    }

    @org.junit.Test
    public void getAssignedOption() throws Exception {
        choices.add("Web Develoment");
        choices.add("Cyber Security");
        choices.add("Java Programming");
        choices.add("UI/UX Design");
        stu.setAssignedOption("Cyber Security");

        assertEquals("Cyber Security", stu.getAssignedOption());
    }

    @org.junit.Test
    public void getStatus() throws Exception {

        assertEquals("", stu.getStatus());
    }
}