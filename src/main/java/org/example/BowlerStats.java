package org.example;

import java.util.ArrayList;

public class BowlerStats {
    private int runsScoredAgainst = 0;
    private final ArrayList<Batsman> wicketsTakenList = new ArrayList<>();
    private int ballsBowled = 0;

    public void addWicket(Batsman batsman) {
        wicketsTakenList.add(batsman);
    }

    public int getWicketsTaken() {
        return wicketsTakenList.size();
    }

    public int getRunsScoredAgainst() {
        return runsScoredAgainst;
    }

    public void addRunsScoredAgainst(int runs) {
        this.runsScoredAgainst += runs;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }

    public void incrementBallsBowled() {
        this.ballsBowled++;
    }
}
