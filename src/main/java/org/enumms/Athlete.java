package org.enumms;

import java.util.List;

public class Athlete implements Comparable<Athlete>{
    public int athleteNumber;
    public String athleteName;
    public String countryCode;
    public String timeResults;
    public List<ShootingResult> shootingRanges;


    public Athlete(int athleteNumber, String athleteName, String countryCode, String timeResults, List<ShootingResult> shootingRanges) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.timeResults = timeResults;
        this.shootingRanges = shootingRanges;
    }

    @Override
    public int compareTo(Athlete other) {
        return Double.compare(this.getFinalTime(), other.getFinalTime());
    }

    public double getFinalTime() {
        double skiTime = convertTimeToSeconds(timeResults);
        int penaltyTime = 0;

        for (ShootingResult shootingResult : shootingRanges) {
            penaltyTime += shootingResult.getPenaltyTimeInSeconds();
        }
        return skiTime + penaltyTime;
    }

    private double convertTimeToSeconds(String timeResults) {
        String[] times = timeResults.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteNumber=" + athleteNumber +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", timeResults='" + timeResults + '\'' +
                ", shootingRanges=" + shootingRanges +
                '}';
    }

    public Ranking getRanking(int rank) {
        switch (rank) {
            case 0:
                return Ranking.WINNER;
            case 1:
                return Ranking.RUNNER_UP;
            case 2:
                return Ranking.THIRD_PLACE;
            default:
                throw new IllegalArgumentException("Invalid rank: " + rank);
        }
    }

    public String getAthleteName() {
        return this.athleteName;
    }
}
