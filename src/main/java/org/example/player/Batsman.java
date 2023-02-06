package org.example.player;

public interface Batsman {


    void addRuns(int runs);

    String getName();

    int getRuns();

    void setBowledBy(Bowler bowledBy);

    Bowler getBowledBy();

    int getBallsPlayed();

    void incrementBallsPlayed();

    int getFoursScored();

    int getSixesScored();
}
