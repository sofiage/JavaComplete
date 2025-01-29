package org.enumms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseCSV {
    public static
    List<Athlete> parseCSV(String filePath) throws IOException {

        List<Athlete> athletes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(",");
            if(columns.length < 4) {
                continue;
            }

            String athleteNumberStr = columns[0].trim();
            int athleteNumber = 0;


            try {

                if (!athleteNumberStr.isEmpty()) {
                    athleteNumber = Integer.parseInt(athleteNumberStr);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid athlete number: " + athleteNumber);
                continue;
            }

            String athleteName = columns[1].trim();
            String countryCode = columns[2].trim();
            String timeResults = columns[3].trim();
            List<ShootingResult> shootingRanges = new ArrayList<>();
            for(int i = 4; i < columns.length; i++){
                shootingRanges.add(new ShootingResult(columns[i].trim()));
            }
            athletes.add(new Athlete(athleteNumber, athleteName, countryCode, timeResults, shootingRanges));
        }
        reader.close();
        return athletes;
    }
}
