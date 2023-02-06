package org.example.utils;

import org.example.player.Bowler;

public class BatsmanStats {
    private int runsScored = 0;
    private int foursScored = 0;
    private int sixesScored = 0;
    private int ballsPlayed = 0;
    private Bowler bowledBy = null;


    public int getRunsScored() {
        return runsScored;
    }

    public void addRunsScored(int runs) {
        this.runsScored += runs;
        if(runs == 4) foursScored += 1;
        else if (runs == 6) sixesScored += 1;
    }

    public int getFoursScored() {
        return foursScored;
    }

    public int getSixesScored() {
        return sixesScored;
    }

    public Bowler getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Bowler bowledBy) {
        this.bowledBy = bowledBy;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void incrementBallsPlayed() {
        this.ballsPlayed++;
    }


}
