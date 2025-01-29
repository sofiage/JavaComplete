package org.exception;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StudentRepository {

    private Set<Student> students;

    public StudentRepository() {
        this.students = new TreeSet<>(Comparator.comparing(Student::getLastName).thenComparing(Student::getDateOfBirth));
    }

    //Add student to repository
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can be null");
        }
        if (students.contains(student)) {
            throw new IllegalArgumentException("Student with this ID exists");
        }
        students.add(student);
    }

    //Delete Student by ID
    public void deleteStudent(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove == null) {
            throw new IllegalArgumentException("Student doesn't exist");
        }
        students.remove(studentToRemove);
    }

    //Rerieve Students by Age
    public Set<Student> retrieveAllStudentsByAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can not be negative");
        }
        Set<Student> studentSet = new TreeSet<>();
        for (Student student : students) {
            if (student.calculateAge() == age) {
                studentSet.add(student);
            }
        }
        return studentSet;
    }

    public Set<Student> orderedListOfStudent(String orderBy) {
        Set<Student> studentOrderedSet;
        if ("lastName".equalsIgnoreCase(orderBy)) {
            studentOrderedSet = new TreeSet<>(Comparator.comparing(Student::getLastName));
        } else if ("dateOfBirth".equalsIgnoreCase(orderBy)) {
            studentOrderedSet = new TreeSet<>(Comparator.comparing(Student::getDateOfBirth));
        } else {
            throw new IllegalArgumentException("Invalid sorting criteria");
        }
        studentOrderedSet.addAll(students);
        return studentOrderedSet;
    }

    public Set<Student> getAllStudents(){
        return students;
    }
}



