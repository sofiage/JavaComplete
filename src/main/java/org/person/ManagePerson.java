package org.person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ManagePerson {
    /**
     * Loads a list of Person objects from a specified file
     *
     * @param inputFile the path to the inputFile
     * @return a list of Person objects
     * @throws IOException if an I/O error occurs while reading from the file
     */

    public static List<Person> loadFromFile(String inputFile) {
        try (Stream<String> lines = Files.lines(Paths.get(inputFile))) {
            return lines.map(line -> {
                        String[] parts = line.trim().split(",");
                        if (parts.length < 3) {
                            System.out.println("Invalid line :" + line);
                            return null;
                        }
                        String firstName = parts[0].trim();
                        String lastName = parts[1].trim();
                        LocalDate dateOfBirth = LocalDate.parse(parts[2].trim());
                        return new Person(firstName, lastName, dateOfBirth);
                    })
                    .collect(Collectors.toList());
        } catch (DateTimeException | IOException e) {
            System.err.println("Invalid date format in line: ");
            return null;
        }
    }

    /**
     * @param personList  is the list of Person objects to be filtered and sorted
     * @param targetMonth is the month to filter by
     * @return a filtered and sorted list of Person objects
     */

    public static List<Person> filterAndSortPersonList(List<Person> personList, int targetMonth) {
        return personList.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    /**
     * @param sortedList is the list of Person objects to write
     * @param outputFile is the path to the outputFile
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public static void writeToFile(List<Person> sortedList, String outputFile)  {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
            for (Person person : sortedList) {
                writer.write(person.getFirstName() + " " + person.getLastName());
                writer.newLine();
            }
        }catch(IOException e){
            System.err.println("Error writing to file " + e.getMessage());
        }
    }
}

