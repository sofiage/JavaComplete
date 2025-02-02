package org.person;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * This class is used to create a file with person data details.
 * Each line contains: firstName, lastName, dateOfBirth(yyyy-MM-dd).
 */

public class FileCreater {
/**
* @param fileName is the name of the file that is being created
*/


    public static void createFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Alina,Georgescu,1985-12-10");
            writer.newLine();
            writer.write("Alexia,Bruma,2000-10-10");
            writer.newLine();
            writer.write("Ioan,Benone,1985-11-01");
            writer.newLine();
            writer.write("Georgiana,Paraschivu,2002-12-02");
            writer.newLine();
            writer.write("Flavius,Isachi,1999-12-14");
            writer.newLine();
            writer.write("Vlad,Voicu,1989-12-09");
            writer.newLine();
            writer.write("Hera,Morarescu,2005-12-07");
            writer.newLine();
            writer.write("Alexandru,Isarescu,1987-11-02");
            writer.newLine();
            writer.write("Virgil,Bunea,1960-12-01");
            writer.newLine();
            writer.write("Emilia,Prodan,1997-07-07");
            writer.newLine();
            writer.write("Vera,Matei,2000-10-02");
            writer.newLine();
            writer.write("Veronica,Popescu,1989-11-08");
            writer.newLine();
            writer.write("Melania,Popovici,1990-09-09");
            writer.newLine();
            writer.write("Larisa,Nadiu,1991-12-10");
            writer.newLine();
            writer.write("Emil,Pop,1995-10-03");
            writer.newLine();

            System.out.println("File was created successfully!");

        } catch (Exception e) {

            System.out.println("Error while writing the file " + e.getMessage());
        }
    }
}
