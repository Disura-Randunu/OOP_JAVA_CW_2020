import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub>{

    private int wins;
    private int draws;
    private int defeats;
    private int receivedGoals;
    private int scoredGoals;
    private int points;
    private int playedMatches;

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
        return "FootballClub{" +
                super.toString() + '\n' +
                "wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", receivedGoals=" + receivedGoals +
                ", scoredGoals=" + scoredGoals +
                ", points=" + points +
                ", playedMatches=" + playedMatches +
                '}';
    }

    @Override
    public int compareTo(FootballClub club) {
	
	// Have to implement the Equal option (When points are equal, sort by goal diff) 
        
	if(points == club.getPoints()){
            return 0;
        }
        else if(points < club.getPoints()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
