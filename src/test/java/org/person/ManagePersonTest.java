package org.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class ManagePersonTest {

    private Path tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = Files.createTempFile("test", "txt");
    }

    @AfterEach
    public void deleteAfterUsage() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void loadFromFile() throws IOException {
        String data = "Alina,Georgescu,1985-12-10\nHera,Morarescu,2005-12-07";
        Files.write(tempFile, data.getBytes());

        List<Person> personList = ManagePerson.loadFromFile(tempFile.toString());

        assertNotNull(personList);
        assertEquals(2, personList.size());
        assertEquals(new Person("Alina", "Georgescu", LocalDate.of(1985, 12, 10)), personList.get(0));
        assertEquals(new Person("Hera", "Morarescu", LocalDate.of(2005, 12, 7)), personList.get(1));

    }

    @Test
    public void loadFromFile_InvalidData() throws IOException {
        String invalidData = "Alina,Georgescu,1985-12-10\n,Morarescu,1990-10-12";
        Files.write(tempFile, invalidData.getBytes());

        List<Person> personList = ManagePerson.loadFromFile(tempFile.toString());
        assertNotNull(personList);
        assertEquals(2, personList.size());//load only the valid data
        assertEquals(new Person("Alina", "Georgescu", LocalDate.of(1985, 12, 10)), personList.get(0));
    }

    @Test
    public void loadFromFile_EmptyFile() throws IOException {
        Files.write(tempFile, "".getBytes());

        List<Person> personList = ManagePerson.loadFromFile(tempFile.toString());
        assertNotNull(personList);
        assertEquals(0, personList.size());

    }

    @Test
    public void filterAndSortPersonList() {
        List<Person> sortedPerson = Arrays.asList(
                new Person("Jessica", "Bell", LocalDate.of(1990, 10, 12)),
                new Person("Jorge", "Maier", LocalDate.of(1989, 12, 1)),
                new Person("Bob", "Dylan", LocalDate.of(2000, 1, 15)));

        List<Person> result = ManagePerson.filterAndSortPersonList(sortedPerson, 10);

        assertEquals(1, result.size());
        assertEquals("Jessica", result.get(0).getFirstName());
        assertEquals("Bell", result.get(0).getLastName());
    }

    @Test
    public void filterAndSortPersonList_NoMatchFound(){
        List<Person> personList = Arrays.asList(
                new Person("Jessica", "Bell", LocalDate.of(1990, 10, 12)),
                new Person("Jorge", "Maier", LocalDate.of(1989, 12, 1)));
        List<Person> result = ManagePerson.filterAndSortPersonList(personList,50);

        assertTrue(result.isEmpty());
    }

    @Test
    public void filterAndSortPersonList_MultiplePersons(){
        List<Person> sortedPerson = Arrays.asList(
                new Person("Jessica", "Bell", LocalDate.of(1990, 10, 12)),
                new Person("Jorge", "Maier", LocalDate.of(1989, 10, 1)),
                new Person("Bob", "Dylan", LocalDate.of(2000, 1, 15)));

        List<Person> result = ManagePerson.filterAndSortPersonList(sortedPerson, 10);

        assertEquals(2, result.size());
        assertEquals("Jessica", result.get(0).getFirstName());
        assertEquals("Jorge", result.get(1).getFirstName());
    }

    @Test
    void writeToFile_ValidData() throws IOException {
        List<Person> personList = List.of(
                new Person("Jeremy", "Nash", LocalDate.of(2000, 12, 12)),
                new Person("Lola", "Smith", LocalDate.of(2005, 8, 7)));

        ManagePerson.writeToFile(personList, tempFile.toString());

            List<String> lines = Files.readAllLines(tempFile);
            assertEquals(2, lines.size());
            assertEquals("Jeremy Nash", lines.get(0));
            assertEquals("Lola Smith", lines.get(1));

        }
    }
