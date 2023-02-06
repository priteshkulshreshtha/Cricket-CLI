package org.example.utils;


import org.example.player.Batsman;
import org.example.player.Bowler;
import org.example.cricketTeam.CricketTeam;

public class MatchStatsUtil {

    private MatchStatsUtil() {}

    public static void printBattingStats(CricketTeam team) {
        System.out.println("\n");
        System.out.printf("Batting Stats for %s\n", team.getTeamName());
        System.out.printf("%7s|%14s|%3s | %3s | %3s | %3s\n", "Name", "","balls","runs","4","6");


        for(Batsman batsman: team.getTeamMembers()) {
            System.out.print(batsman.getName()+"|");

            if (batsman.getBallsPlayed() == 0) {
                System.out.printf("%14s|", "");
            } else if (batsman.getBowledBy() == null) {
                System.out.printf("%14s|", "not out");
            } else {
                System.out.printf("%14s|", "b. " + batsman.getBowledBy().getName());
            }

            System.out.printf(" %4d | %4d | %3d | %3d\n",
                    batsman.getBallsPlayed(),
                    batsman.getRuns(),
                    batsman.getFoursScored(),
                    batsman.getSixesScored()
            );


        }
    }

    public static void printBowlingStats(CricketTeam team) {
        System.out.println("\n");
        System.out.printf("Bowling Stats for %s\n", team.getTeamName());

        System.out.printf("%7s|%4s|%4s|%4s\n","Name","W","O","R");
        for(Bowler bowler: team.getTeamMembers().subList(11-team.getNumberOfBowlers(), 11)) {
            System.out.print(bowler.getName()+"|");

            System.out.printf("%4d|%2d.%1d|%4d\n",
                    bowler.getWicketsTaken(),
                    bowler.getBallsBowled()/6,
                    bowler.getBallsBowled()%6,
                    bowler.getRunsScoredAgainst()
            );

        }

    }

}
