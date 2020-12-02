import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    private HashMap<String, FootballClub> premierLeagueClubs = new HashMap<>();
    private HashMap<LocalDate, PlayedMatch> playedMatches = new HashMap<>();

//    private List<FootballClub> premierLeagueClubs = new ArrayList<>();
    private List<PlayedMatch> matches = new ArrayList<>();

//    private HashMap<Date, PlayedMatch> playedMatches = new HashMap<>();

    public FootballClub getClubByName(String name){
        if (premierLeagueClubs.containsKey(name)){
            return premierLeagueClubs.get(name);
        }
        return null;
    }

    @Override
    public void addFootballClub(String clubName, String location) {

        if(getClubByName(clubName) == null){
            FootballClub club = new FootballClub(clubName, location);
            premierLeagueClubs.put(clubName, club);
        } else {
            System.out.println("Club Already Exists. Please Try Again!");
        }

    }

    @Override
    public void addPlayedMatch(String homeClub, String visitorClub, LocalDate matchDate, int homeScored, int visitorScored) {


        for (LocalDate date : playedMatches.keySet()){
            if (playedMatches.get(date).)
        }
        PlayedMatch playedMatch = new PlayedMatch(premierLeagueClubs.get(homeClub), premierLeagueClubs.get(visitorClub), matchDate);
        playedMatch.setHomeScoredGoals(homeScored);
        playedMatch.setVisitorScoredGoals(visitorScored);

    }

    @Override
    public void deleteFootballClub(String clubName) {
        if(getClubByName(clubName) != null){
            premierLeagueClubs.remove(clubName);
        }else {
            System.out.println("Club Doesn't Exist. Please Try Again!");
        }
    }

    @Override
    public void displayClubStats(String clubName) {
        if(getClubByName(clubName) != null){
            getClubByName(clubName).toString();
        }
    }

    @Override
    public void displayPremierLeagueTable() {

        List<FootballClub> clubs = new ArrayList<>(premierLeagueClubs.values());
        Collections.sort(clubs);

        for(FootballClub club: clubs){
            club.toString();
        }
    }

    public void mainMenu(){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        Scanner scanner = new Scanner(System.in);
        String clubName = "";

        boolean exitProgram = false;

        while (!exitProgram){

            System.out.println("Add Football Club            - A");
            System.out.println("Delete Football Club         - D");
            System.out.println("Display Football Club Stats  - S");
            System.out.println("Display Premier League Table - P");
            System.out.println("Exit Program                 - E\n");
            System.out.println("Enter Option: ");

            String option = scanner.nextLine();
            // Have to Validate through RegEx (Capital Option Letter and Simple Option Letter)

            switch (option){
                case "A":
                    // Validate through RegEx
                    System.out.println("Enter Football Club Name:");
                    clubName = scanner.nextLine();

                    System.out.println("Enter Location of the Club:");
                    String clubLocation = scanner.nextLine();

                    premierLeagueManager.addFootballClub(clubName, clubLocation);
                    break;

                case "D":
                    // Validate through RegEx
                    System.out.println("Enter Football Club Name to Delete");
                    clubName = scanner.nextLine();
                    premierLeagueManager.deleteFootballClub(clubName);
                    break;

                case "S":
                    System.out.println("Enter Club Name to Display Stats: ");
                    clubName = scanner.nextLine();
                    premierLeagueManager.displayClubStats(clubName);
                    break;

                case "P":
                    premierLeagueManager.displayPremierLeagueTable();
                    break;

                case "M":
                    System.out.println("Information:\n* Home Club = Club which is located where the match takes place");
                    System.out.println("* Visitor Club = Club which comes to play at Home club's Location");

                    System.out.println("\nEnter Match Date (YYYY/M/D):");
                    String date = scanner.nextLine();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
                    LocalDate matchDate = LocalDate.parse(date, dateFormat);
                    
                    // Have to check if exists in Hashmap
                    System.out.println("Enter Home Club Name:");
                    String homeClubInput = scanner.nextLine();
                    FootballClub homeClub = premierLeagueClubs.get(homeClubInput);

                    // Have to check if exists in Hashmap
                    System.out.println("Enter Visitor Club Name:");
                    String visitorClubInput = scanner.nextLine();
                    FootballClub visitorClub = premierLeagueClubs.get(visitorClubInput);

                    // Need to Validate Integer
                    System.out.println("Enter Scored Goals for " + homeClubInput + ":");
                    int homeScoredGoals = scanner.nextInt();

                    // Need to Validate Integer
                    System.out.println("Enter Scored Goals for " + visitorClubInput + ":");
                    int visitorScoredGoals = scanner.nextInt();

                    premierLeagueManager.addPlayedMatch(homeClubInput, visitorClubInput, matchDate, homeScoredGoals, visitorScoredGoals);

                case "E":
                    exitProgram = true;
                    break;

                default:
                    System.out.println("Invalid Option. Please Try Again!");
            }
        }

    }

    public static void main(String[] args) {




    }
}
