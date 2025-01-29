package org.enumms;

public class ShootingResult {
    public String shots;

    public ShootingResult(String column) {
        this.shots = column;
    }

    public int getPenaltyTimeInSeconds(){
        long misses = shots.chars().filter(c -> c == 'o').count();
        return (int) misses * 10;
    }
}
