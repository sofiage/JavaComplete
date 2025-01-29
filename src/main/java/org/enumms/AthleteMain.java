package org.enumms;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class AthleteMain {
    public static void main(String[] args) {
        try {
            List<Athlete> athletes = ParseCSV.parseCSV("src/main/java/org/example/SkiBiathlonResults.csv");
            athletes.sort(Comparator.naturalOrder());

            if (athletes.size() < 3){
                System.out.println("Not enough athletes to determine top three finishers");
                return;
            }
            Athlete winner = athletes.get(0);
            Athlete runnerUp = athletes.get(1);
            Athlete thirdPlace = athletes.get(2);

            System.out.println("The top three finishers are: ");
            System.out.println(winner.getAthleteName() + " is " + winner.getRanking(0) + " " + winner.getFinalTime());
            System.out.println(runnerUp.getAthleteName() + " is " + runnerUp.getRanking(1) + " " + runnerUp.getFinalTime());
            System.out.println(thirdPlace.getAthleteName() + " is " + thirdPlace.getRanking(2) + " " + thirdPlace.getFinalTime());

        } catch(IOException e){
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }
}
