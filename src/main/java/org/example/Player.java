package org.example;

import java.util.Random;

public class Player implements Batsman, Bowler{

    private final String name;
    private final BatsmanStats batsmanStats = new BatsmanStats();
    private final BowlerStats bowlerStats = new BowlerStats();
    private final short battingPower;
    private final short bowlingPower;



    public String getName() {
        return name;
    }

    @Override
    public void setBowledBy(Bowler bowledBy) {
        batsmanStats.setBowledBy(bowledBy);
    }

    @Override
    public Bowler getBowledBy() {
        return batsmanStats.getBowledBy();
    }

    public Player(short battingPower, short bowlingPower ) {
        this.battingPower = battingPower;
        this.bowlingPower = bowlingPower;

        this.name = getRandomName();
    }

    private String getRandomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    public void addRuns(int runs) {
        batsmanStats.addRunsScored(runs);
    }

    public void addRunsAgainst(int runs) {
        bowlerStats.addRunsScoredAgainst(runs);
    }

    public void bowled(Batsman batsman) {
        bowlerStats.addWicket(batsman);
    }

    @Override
    public void incrementBallsBowled() {
        bowlerStats.incrementBallsBowled();
    }

    @Override
    public int getBallsBowled() {
        return bowlerStats.getBallsBowled();
    }

    @Override
    public int getBallsPlayed() {
        return batsmanStats.getBallsPlayed();
    }

    @Override
    public void incrementBallsPlayed() {
        batsmanStats.incrementBallsPlayed();
    }

    public int getRuns() {
        return batsmanStats.getRunsScored();
    }

    @Override
    public int getFoursScored() {
        return batsmanStats.getFoursScored();
    }

    @Override
    public int getSixesScored() {
        return batsmanStats.getSixesScored();
    }

    public int getWicketsTaken() {
        return bowlerStats.getWicketsTaken();
    }

    @Override
    public int getRunsScoredAgainst() {
        return bowlerStats.getRunsScoredAgainst();
    }
}
