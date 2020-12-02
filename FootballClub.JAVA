import java.io.*;
import java.util.*;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
    private static final long serialVersionUID = 1L;

    private int wins;
    private int draws;
    private int defeats;
    private int receivedGoals;
    private int scoredGoals;
    private int points;
    private int playedMatches;

    FootballClub(String name, String location){
        super(name, location);
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getReceivedGoals() {
        return receivedGoals;
    }

    public void setReceivedGoals(int receivedGoals) {
        this.receivedGoals = receivedGoals;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPlayedMatches() {
        return playedMatches;
    }

    public void setPlayedMatches(int playedMatches) {
        this.playedMatches = playedMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FootballClub that = (FootballClub) o;

        return wins == that.wins &&
                draws == that.draws &&
                defeats == that.defeats &&
                receivedGoals == that.receivedGoals &&
                scoredGoals == that.scoredGoals &&
                points == that.points &&
                playedMatches == that.playedMatches;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wins, draws, defeats, receivedGoals, scoredGoals, points, playedMatches);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Points         : " + points + '\n' +
                "Wins           : " + wins + '\n' +
                "Draws          : " + draws + '\n' +
                "Defeats        : " + defeats + '\n' +
                "Scored Goals   : " + scoredGoals + '\n' +
                "Received Goals : " + receivedGoals + '\n' +
                "Matches Played : " + playedMatches + '\n';
    }

    @Override
    public int compareTo(FootballClub club) {
        if(this.points == club.getPoints()){

            int thisGoalDiff = this.scoredGoals - this.receivedGoals;
            int otherGoalsDiff = club.scoredGoals - club.receivedGoals;

            if (thisGoalDiff == otherGoalsDiff){
                // Sort by Scored Goals
                if (this.scoredGoals < club.scoredGoals){
                    return 1;
                }else {
                    return -1;
                }
            } else {
                // Sort by Goal Difference
                if(thisGoalDiff < otherGoalsDiff){
                    return 1;
                }else {
                    return -1;
                }
            }

        }
        else if(this.points < club.getPoints()){    // Sort by Points
            return 1;
        }
        else{
            return -1;
        }
    }
}
