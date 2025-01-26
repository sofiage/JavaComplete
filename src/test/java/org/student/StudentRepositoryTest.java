package org.student;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertThrows;

public class StudentRepositoryTest extends TestCase {


    //TEST CREATE STUDENT FAILS
    @Test
    public void testStudentThrowExceptionForFirstNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("", "Dragomir", LocalDate.of(2003, 10, 12), "male", "123678");
        });
    }

    @Test
    public void testStudentThrowExceptionForLasttNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("Jean", "", LocalDate.of(2003, 10, 12), "male", "123678");
        });
    }

    @Test
    public void testStudentThrowExceptionForInvalidDateOfBirth() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("Ioana", "Macarie", LocalDate.of(1800, 2, 2), "female", "126789");
        });
    }

    @Test
    public void testStudentThrowExceptionWhenGenderIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("Veniamin", "Lenghel", LocalDate.of(2000, 2, 1), "non-binary", "123789");
        });
    }

    @Test
    public void testThrowsExceptionWhenIdIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("Raluca", "Macarie", LocalDate.of(2000, 10, 8), "F", "");
        });
    }

    //TEST ADD STUDENT
    @Test
    public void testAddStudent() {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("Lulu", "Barar", LocalDate.of(1989, 11, 12), "female", "123745");
        repository.addStudent(student);
        assertEquals(1, repository.getAllStudents().size());

    }

    //TEST DELETE STUDENT
    @Test
    public void testDeleteStudent() {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("Lulu", "Barar", LocalDate.of(1989, 11, 12), "female", "123745");
        repository.addStudent(student);
        repository.deleteStudent("123745");
        assertEquals(0, repository.getAllStudents().size());
    }

    //TEST DELETE STUDENT WITH EMPTY ID THROWS EXCEPTION
    @Test
    public void testThrowExceptionWhenDeletingStudentNoId() {
        StudentRepository repository = new StudentRepository();
        assertThrows(IllegalArgumentException.class, () -> {
            repository.deleteStudent("");
        });
    }

    //TEST RETRIEVE STUDENTS BY AGE
    @Test
    public void testRetrieveAllStudentsByAge() {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("Lola", "Bora", LocalDate.of(2000, 1, 12), "female", "123765");
        repository.addStudent(student);
        assertEquals(1, repository.retrieveAllStudentsByAge(25).size());
    }

    //TEST THROW EXCEPTION WHEN AGE IS NEGATIVE
    @Test
    public void testRetrieveStudentsByNegativeAge() {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("Lola", "Bora", LocalDate.of(2000, 11, 12), "female", "123765");
        repository.addStudent(student);
        assertThrows(IllegalArgumentException.class, () -> {
            repository.retrieveAllStudentsByAge(-13);
        });
    }

    //TEST ORDER STUDENTS BY LAST NAME
    public void testOrderedListOfStudentByLastName() {
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("Lucian", "Benone", LocalDate.of(2000, 11, 12), "male", "123765");
        Student student2 = new Student("Luisa", "Blaga", LocalDate.of(2005, 1, 1), "female", "123765");
        repository.addStudent(student1);
        repository.addStudent(student2);
        Set<Student> sortedStudentsByLastName = repository.orderedListOfStudent("lastName");
        assertEquals("Benone", sortedStudentsByLastName.iterator().next().getLastName());
    }

    //TEST ORDER STUDENTS BY LAST DATE OF BIRTH
    @Test
    public void testOrderedListOfStudentsByDateOfBirth() {
        StudentRepository repository = new StudentRepository();
        Student student1 = new Student("Lucian", "Benone", LocalDate.of(2001, 11, 12), "male", "123765");
        Student student2 = new Student("Luisa", "Blaga", LocalDate.of(2005, 1, 1), "female", "123765");
        repository.addStudent(student1);
        repository.addStudent(student2);
        Set<Student> sortedStudentsByDateOfBirth = repository.orderedListOfStudent("dateOfBirth");
        assertEquals(student1, sortedStudentsByDateOfBirth.iterator().next());
    }

    //TEST ORDER STUDENTS BY INVALID CRITERIA
    @Test
    public void testOrderListOfStudentsByInvalidCriteria(){
        StudentRepository repository = new StudentRepository();
        assertThrows(IllegalArgumentException.class, ()-> {
            repository.orderedListOfStudent("InvalidCriteria");
        });
    }
}