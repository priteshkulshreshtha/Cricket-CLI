package org.example.controller;


import org.example.player.Batsman;
import org.example.player.Bowler;
import org.example.cricketTeam.CricketTeam;
import org.example.utils.MatchStatsUtil;

public class MatchController {
    private final CricketTeam teamA;
    private final CricketTeam teamB;

    private final int totalOvers;

    public MatchController(int totalOvers) {
        this.totalOvers = totalOvers;

        teamA = new CricketTeam("Team A", 4);
        teamB = new CricketTeam("Team B", 4);

    }

    public void run() {

        playInning(teamA, teamB);
        playInning(teamB, teamA);

        System.out.printf("\n%s Scored %d runs", teamA.getTeamName(), teamA.getTeamRuns());
        MatchStatsUtil.printBattingStats(teamA);
        MatchStatsUtil.printBowlingStats(teamB);

        System.out.printf("\n%s Scored %d runs", teamB.getTeamName(), teamB.getTeamRuns());
        MatchStatsUtil.printBattingStats(teamB);
        MatchStatsUtil.printBowlingStats(teamA);

    }


    private void playInning(CricketTeam battingTeam, CricketTeam bowlingTeam) {

        int currentOver = 0;
        int currentBall = 0;

        int totalWickets = 0;

        Batsman striker = battingTeam.getNextBatsman();
        Batsman nonStriker = battingTeam.getNextBatsman();
        Bowler bowler = bowlingTeam.getNextBowler();

        while (currentOver < totalOvers) {
            currentBall++;
            striker.incrementBallsPlayed();
            bowler.incrementBallsBowled();


            int runsOnThisBall = nextBall(striker, bowler);


            // Wicket taken on this ball
            if (runsOnThisBall == -1) {
                totalWickets++;

                striker.setBowledBy(bowler);
                bowler.bowled(striker);
                if (totalWickets == 10) {
                    break;
                }
                striker = battingTeam.getNextBatsman();


            }


            // Runs scored on this ball
            else {

                striker.addRuns(runsOnThisBall);
                bowler.addRunsAgainst(runsOnThisBall);
                battingTeam.addTeamRuns(runsOnThisBall);

                // Strike change on odd runs
                if (runsOnThisBall % 2 != 0) {

                    Batsman temp = striker;
                    striker = nonStriker;
                    nonStriker = temp;
                }

            }

            if (currentBall == 6) {
                currentBall = 0;
                currentOver++;
                Batsman temp = striker;
                striker = nonStriker;
                nonStriker = temp;
                bowler = bowlingTeam.getNextBowler();

            }

        }

    }

    private int nextBall(Batsman striker, Bowler bowler) {

        if (Math.random() < 0.05) {
            return -1;
        }

        return (int)(Math.random() * 10) % 7;
    }

}
