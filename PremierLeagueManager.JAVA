import java.util.*;
import java.util.function.Consumer;

public class PremierLeagueManager implements LeagueManager {
    
    /*
        Haven't used the constructor (Not yet implemented because getters and setters will be useless)
        to set the variables. May change in the future.
    */
    private List<FootballClub> footballClubs = new ArrayList<>();

    @Override
    public void addFootballClub() {
        FootballClub footballClub = new FootballClub();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Football Club Name:");
        String clubName = scanner.nextLine();
        footballClub.setName(clubName);

        System.out.println("Enter Location of the Club:");
        String clubLocation = scanner.nextLine();
        footballClub.setLocation(clubLocation);

        System.out.println("Enter Wins:");
        int wins = scanner.nextInt();
        footballClub.setWins(wins);

        System.out.println("Enter draws:");
        int draws = scanner.nextInt();
        footballClub.setDraws(draws);

        System.out.println("Enter defeats:");
        int defeats = scanner.nextInt();
        footballClub.setDefeats(defeats);

        System.out.println("Enter Received Goals:");
        int receivedGoals = scanner.nextInt();
        footballClub.setReceivedGoals(receivedGoals);

        System.out.println("Enter Scored Goals:");
        int scoredGoals = scanner.nextInt();
        footballClub.setScoredGoals(scoredGoals);

        System.out.println("Enter points:");
        int points = scanner.nextInt();
        footballClub.setPoints(points);

        System.out.println("Enter played matches:");
        int playedMatches = scanner.nextInt();
        footballClub.setPlayedMatches(playedMatches);
    }

    @Override
    public void deleteFootballClub() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Football Club Name");
        String name = scanner.nextLine();

        for(FootballClub club : footballClubs){
            if(club.getName().equals(name)){
                footballClubs.remove(club);
                break;
            }
        }
    }

    @Override
    public void displayClubStats() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Club Name to Display Stats: ");
        String clubName = scanner.nextLine();

        for(FootballClub club : footballClubs){
            if(club.getName().equals(clubName)){
                club.toString();
                break;
            }
        }
    }

    @Override
    public void displayPremierLeagueTable() {
        Collections.sort(footballClubs);
        for(FootballClub club: footballClubs){
            System.out.println(club.toString());
        }
    }
}
