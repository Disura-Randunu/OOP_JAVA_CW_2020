import java.time.LocalDate;

public interface LeagueManager {

    void addFootballClub(String clubName, String location);
    void deleteFootballClub(String clubName);
    void addPlayedMatch(String homeClub, String visitorClub, LocalDate matchDate, int homeScored, int visitorScored);
    void displayClubStats(String clubName);
    void displayPremierLeagueTable();

}
