import java.io.*;
import java.time.*;

public class PlayedMatch implements Serializable {
    private static final long serialVersionUID = 1L;

    private FootballClub homeClub;     // Based on which location where the match takes place
    private FootballClub visitorClub;     // Based on which location where the match takes place
    private LocalDate matchDate;
    private String matchLocation;

    private int homeScoredGoals;
    private int visitorScoredGoals;

    public PlayedMatch(FootballClub homeClub, FootballClub visitorClub, LocalDate matchDate) {
        this.homeClub = homeClub;
        this.visitorClub = visitorClub;
        this.matchDate = matchDate;
        this.matchLocation = homeClub.getLocation();
    }

    public String getMatchLocation() {
        return matchLocation;
    }

    public FootballClub getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(FootballClub homeClub) {
        this.homeClub = homeClub;
    }

    public FootballClub getVisitorClub() {
        return visitorClub;
    }

    public void setVisitorClub(FootballClub visitorClub) {
        this.visitorClub = visitorClub;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public int getHomeScoredGoals() {
        return homeScoredGoals;
    }

    public void setHomeScoredGoals(int homeClubGoalsScored) {
        this.homeScoredGoals = homeClubGoalsScored;
    }

    public int getVisitorScoredGoals() {
        return visitorScoredGoals;
    }

    public void setVisitorScoredGoals(int visitorClubGoalsScored) {
        this.visitorScoredGoals = visitorClubGoalsScored;
    }

    public void calculateStats(){

        // Setting Played Matches
        homeClub.setPlayedMatches(homeClub.getPlayedMatches() + 1);
        visitorClub.setPlayedMatches(visitorClub.getPlayedMatches() + 1);

        // Setting Scored Goals
        homeClub.setScoredGoals(homeClub.getScoredGoals() + homeScoredGoals);
        visitorClub.setScoredGoals(visitorClub.getScoredGoals() + visitorScoredGoals);

        // Setting Received Goals
        homeClub.setReceivedGoals(homeClub.getReceivedGoals() + visitorScoredGoals);
        visitorClub.setReceivedGoals(visitorClub.getReceivedGoals() + homeScoredGoals);

        // Setting Wins/Defeats/Draws/Points
        if (homeScoredGoals > visitorScoredGoals){
            homeClub.setWins(homeClub.getWins() + 1);
            homeClub.setPoints(homeClub.getPoints() + 3);
            visitorClub.setDefeats(visitorClub.getDefeats() + 1);

        }else if (visitorScoredGoals > homeScoredGoals){
            visitorClub.setWins(visitorClub.getWins() + 1);
            visitorClub.setPoints(visitorClub.getPoints() + 3);
            homeClub.setDefeats(homeClub.getDefeats() + 1);

        } else {
            homeClub.setDraws(homeClub.getDraws() + 1);
            homeClub.setPoints(homeClub.getPoints() + 1);
            visitorClub.setDraws(visitorClub.getDraws() + 1);
            visitorClub.setPoints(visitorClub.getPoints() + 1);
        }
    }
}
