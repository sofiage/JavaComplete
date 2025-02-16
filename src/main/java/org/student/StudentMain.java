package org.student;

import java.time.LocalDate;
import java.util.Set;

public class StudentMain {
    public static void main(String[] args) {
        //Create student repository and add students
        StudentRepository repository = new StudentRepository();
        repository.addStudent(new Student("Ioan", "Popescu", LocalDate.of(2000, 10, 3), "male", "123456"));
        repository.addStudent(new Student("Ioana", "Popovici", LocalDate.of(1980, 1, 7), "F", "123456"));
        repository.addStudent(new Student("Robert", "Marinescu", LocalDate.of(2005, 10, 3), "M", "123456"));
        repository.addStudent(new Student("Alina", "Georgescu", LocalDate.of(2002, 11, 5), "female", "123456"));
        repository.addStudent(new Student("Flaviu", "Piedone", LocalDate.of(1999, 4, 8), "male", "123456"));

        //Display the list of all students
        System.out.println("Display all students");
        for (Student student : repository.getAllStudents()) {
            System.out.println(student);
        }

        //Order Student repository by Last Name
        System.out.println("\nStudents sorted by Last Name");
        Set<Student> studentsOrderedByLastName = repository.orderedListOfStudent("lastName");
        for (Student student : studentsOrderedByLastName) {
            System.out.println(student);
        }

        //Order Student repository by Date of Birth
        System.out.println("\nStudents sorted by Date of Birth: ");
        Set<Student> studentsOrderedByDateOfBirth = repository.orderedListOfStudent("dateOfBirth");
        for (Student student : studentsOrderedByDateOfBirth) {
            System.out.println(student);
        }

        //Delete a student by ID and retrieve the student list after deletion
        repository.deleteStudent("123456");
        System.out.println("\nStudent list after deletion: ");
        for (Student student : repository.getAllStudents()) {
            System.out.println(student);
        }

        //Retrieve students by age
        Set<Student> studentByAge = repository.retrieveAllStudentsByAge(25);
        System.out.println("\nStudents with age 25: ");
        for (Student student : studentByAge) {
            System.out.println(student);
        }
    }
}
