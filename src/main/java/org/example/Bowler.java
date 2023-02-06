package org.example;

public interface Bowler {
    String getName();

    void addRunsAgainst(int runs);

    void bowled(Batsman batsman);

    void incrementBallsBowled();

    int getBallsBowled();

    int getWicketsTaken();

    int getRunsScoredAgainst();
}
