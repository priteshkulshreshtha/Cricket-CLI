package org.example.cricketTeam;

import org.example.player.Batsman;
import org.example.player.Bowler;
import org.example.player.Player;

import java.util.ArrayList;

public class CricketTeam {

    private final ArrayList<Player> teamMembers = new ArrayList<>();
    private final int numberOfBowlers;
    private final String teamName;
    private int nextBowlerId;
    private int currentBatsman = 0;
    private int teamRuns = 0;
    public String getTeamName() {
        return teamName;
    }

    public CricketTeam(String teamName, int numberOfBowlers) {
        this.numberOfBowlers = numberOfBowlers;

        for(int i=0; i<11-numberOfBowlers; i++) {
            addBatsman();
        }

        for(int i=0; i<numberOfBowlers; i++) {
            addBowler();
        }

        this.nextBowlerId = 11 - numberOfBowlers;
        this.teamName = teamName;

    }

    public void addBatsman() {
        short battingPower = (short)(Math.random() * 100);
        if (battingPower < 50) {
            battingPower = (short)(100 - battingPower);
        }

        teamMembers.add(new Player(battingPower, (short)(100 - battingPower)));
    }

    public void addBowler() {
        short bowlingPower = (short)(Math.random() * 100);
        if (bowlingPower < 50) {
            bowlingPower = (short)(100 - bowlingPower);
        }

        teamMembers.add(new Player( (short)(100 - bowlingPower), bowlingPower));

    }

    public Bowler getNextBowler() {

        return teamMembers.get(getNextBowlerId());

    }

    public Batsman getNextBatsman() {
        return teamMembers.get(currentBatsman++);
    }

    public int getNextBowlerId() {
        int returnBowler = nextBowlerId + 1;
        if (returnBowler >= 11) {
            setNextBowlerId(11 - numberOfBowlers);
            return nextBowlerId;
        }
        setNextBowlerId(returnBowler);
        return nextBowlerId;
    }

    public void setNextBowlerId(int nextBowlerId) {
        this.nextBowlerId = nextBowlerId;
    }

    public int getTeamRuns() {
        return teamRuns;
    }

    public void addTeamRuns(int runs) {
        this.teamRuns += runs;
    }

    public ArrayList<Player> getTeamMembers() {
        return teamMembers;
    }

    public int getNumberOfBowlers() {
        return numberOfBowlers;
    }
}
