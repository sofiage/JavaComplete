package org.enumms;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class AthleteTest {
    String csvFile = " 11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
            " 1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
            " 27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx\n" ;

    File tempFile;

    @Test
    @Before
    public void setCsvFile() throws IOException {
        tempFile = File.createTempFile("csvFile", ".csv");
        tempFile.deleteOnExit();
        try(FileWriter writer= new FileWriter(tempFile)){
            writer.write(csvFile);
        }
    }

    @Test
    public void testParseCSV() throws IOException {
        List<Athlete> athletes = ParseCSV.parseCSV(tempFile.getAbsolutePath());
        Collections.sort(athletes);

        assertEquals(3, athletes.size());
        assertEquals("Piotr Smitzer", athletes.get(0).getAthleteName());
    }

    @Test
    public void testGetRanking() throws IOException {
        List<Athlete> athletes = ParseCSV.parseCSV(tempFile.getAbsolutePath());
        Collections.sort(athletes);

        assertEquals(Ranking.WINNER, athletes.get(0).getRanking(0));
        assertEquals(Ranking.RUNNER_UP, athletes.get(1).getRanking(1));
        assertEquals(Ranking.THIRD_PLACE, athletes.get(2).getRanking(2));
    }

    @Test
    public void testGetFinalTime() throws IOException {
        List<Athlete> athletes = ParseCSV.parseCSV(tempFile.getAbsolutePath());
        Collections.sort(athletes);

        assertEquals(1810.0, athletes.get(0).getFinalTime());
        assertEquals(1815.0, athletes.get(1).getFinalTime());
        assertEquals(1857.0, athletes.get(2).getFinalTime());
    }

}
