package org.person;
import java.io.IOException;
import java.util.List;

public class PersonMain {

    public static void main(String[] args) {
/**
 * @param inputFilePath is a variable that stores the input file name
 * @param outputFilePath is a variable that stores the output file name
 */
        String fileName = "person_data.txt";
        FileCreater.createFile(fileName);

            String inputFilePath = "person_data.txt";
            String outputFilePath = "filtered_person_data.txt";
            int targetMonth = 12;

            //Load the data from the file
            List<Person> personList = ManagePerson.loadFromFile(inputFilePath);
            System.out.println("\n" + personList);

            //Filter the list by target month then by name

        List<Person> filteredSortedList = ManagePerson.filterAndSortPersonList(personList, targetMonth);
            ManagePerson.writeToFile(filteredSortedList, outputFilePath);
            System.out.println("\n" + "Filtered and sorted list is written to " + outputFilePath + " file");


        }
    }

