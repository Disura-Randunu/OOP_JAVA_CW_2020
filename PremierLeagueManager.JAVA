import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    private static final int CLUBS_LIMIT = 20;
    private static final String CLUBS_SAVE_FILE = "clubsSaveData.ser";
    private static final String MATCHES_SAVE_FILE = "matchesSaveData.ser";

    private HashMap<String, FootballClub> premierLeagueClubs;
    private HashMap<LocalDate, PlayedMatch> playedMatches;

    public FootballClub getClubByName(String name){
        // Utility Method to get the Club from the HashMap by passing the Name
        if (premierLeagueClubs.containsKey(name)){
            return premierLeagueClubs.get(name);
        }
        return null;
    }

    @Override
    public void addFootballClub(String clubName, String location) {

        if (premierLeagueClubs.size() <= CLUBS_LIMIT){
            if(getClubByName(clubName) == null){
                FootballClub club = new FootballClub(clubName, location);
                premierLeagueClubs.put(clubName, club);
            } else {
                System.out.println("Club Already Exists. Please Try Again!");
            }
        }else {
            System.out.println("Maximum amount of clubs is exceeding. Cannot add a new club!");
        }
    }

    @Override
    public void addPlayedMatch(String homeClub, String visitorClub, LocalDate matchDate, int homeScored, int visitorScored) {

        boolean available = true;

        if (playedMatches != null){
            for (PlayedMatch match : playedMatches.values()){
                System.out.println(match.getHomeClub().getName() + " | " + match.getVisitorClub().getName());
                if (match.getHomeClub().getName().equals(homeClub)){
                    if (match.getVisitorClub().getName().equals(visitorClub)){
                        available = false;
                        break;
                    }
                }
            }

            if (available){
                PlayedMatch playedMatch = new PlayedMatch(premierLeagueClubs.get(homeClub), premierLeagueClubs.get(visitorClub), matchDate);
                playedMatch.setHomeScoredGoals(homeScored);
                playedMatch.setVisitorScoredGoals(visitorScored);
                playedMatches.put(matchDate, playedMatch);
                playedMatch.calculateStats();
                System.out.println("Match Information Updated Successfully!");
            } else {
                System.out.println("Match Already Exists!");
            }
        }
    }

    @Override
    public void deleteFootballClub(String clubName) {
        if(getClubByName(clubName) != null){
            premierLeagueClubs.remove(clubName);                    // Need to Verify Deletion
        }else {
            System.out.println("Club Doesn't Exist. Please Try Again!");
        }
    }

    @Override
    public void displayClubStats(String clubName) {
        if(getClubByName(clubName) != null){
            System.out.println(getClubByName(clubName).toString());
        }
    }

    @Override
    public void displayPremierLeagueTable() {

        List<FootballClub> clubs = new ArrayList<>(premierLeagueClubs.values());
        Collections.sort(clubs);

        System.out.println("<<<<<----------- Premier League Table ----------->>>>>");
        System.out.println("Name | Matches | Wins | Defeats | Draws | Points \n");

        for(FootballClub club: clubs){
            // Need to make use of string formatter to properly add paddings
            String rowContent1 = club.getName() + "  | " + club.getPlayedMatches() + "   |   " +club.getWins() + " |   ";
            String rowContent2 = club.getDefeats() + "   |  " + club.getDraws() + "  |  " + club.getPoints();
            System.out.println( rowContent1 + rowContent2);
        }
    }

    @Override
    public void saveData() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(CLUBS_SAVE_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(premierLeagueClubs);

            try {
                fileOutputStream = new FileOutputStream(MATCHES_SAVE_FILE);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(playedMatches);
            } catch (IOException e){
                e.printStackTrace();
                System.out.println("Error while saving Match Info");
            }

            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Data has been saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Data couldn't be saved (File Error). Please Try Again!");
        }
    }

    @Override
    public void loadData(){

        try {
            FileInputStream fileInputStream = new FileInputStream(CLUBS_SAVE_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            @SuppressWarnings("unchecked")
            HashMap<String, FootballClub> clubs = (HashMap<String, FootballClub>)objectInputStream.readObject();
            premierLeagueClubs = clubs;

            try {
                fileInputStream = new FileInputStream(MATCHES_SAVE_FILE);
                objectInputStream = new ObjectInputStream(fileInputStream);

                @SuppressWarnings("unchecked")
                HashMap<LocalDate, PlayedMatch> matches = (HashMap<LocalDate, PlayedMatch>)objectInputStream.readObject();
                playedMatches = matches;

            } catch (IOException e){
                System.out.println("Saved Matches Data Not Found!");
            }

            objectInputStream.close();
            fileInputStream.close();
            System.out.println("* Saved Data has been Loaded successfully");


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error while Loading. Please Try Again");
        }

    }

    public void mainMenu(){
        File clubFile = new File(CLUBS_SAVE_FILE);

        Scanner scanner = new Scanner(System.in);
        String clubName = "";

        // Load Data from file if file exists already
        if (clubFile.exists()){
            loadData();
        }else {
            System.out.println("* Save Data Not Found. Initializing New Premier League\n");
            premierLeagueClubs = new HashMap<>();
            playedMatches = new HashMap<>();
        }

        boolean exitProgram = false;

        while (!exitProgram){
            System.out.println("\n===========MAIN MENU============\n");
            System.out.println("Add Football Club            - A");
            System.out.println("Add Played Match Info        - M");
            System.out.println("Delete Football Club         - D");
            System.out.println("Display Football Club Stats  - C");
            System.out.println("Display Premier League Table - T");
            System.out.println("Save Data to File            - S");
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

                    addFootballClub(clubName, clubLocation);
                    break;

                case "D":
                    // Validate through RegEx
                    System.out.println("Enter Football Club Name to Delete");
                    clubName = scanner.nextLine();
                    deleteFootballClub(clubName);
                    break;

                case "C":
                    System.out.println("Enter Club Name to Display Stats: ");
                    clubName = scanner.nextLine();
                    displayClubStats(clubName);
                    break;

                case "T":
                    if (premierLeagueClubs != null){
                        displayPremierLeagueTable();
                    }
                    break;

                case "M":
                    System.out.println("Information:\n* Home Club = Club which is located where the match takes place");
                    System.out.println("* Visitor Club = Club which comes to play at Home club's Location");

                    // Need to Validate Date Pattern
                    System.out.println("\nEnter Match Date (YYYY/M/D):");
                    String date = scanner.nextLine();
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
                    LocalDate matchDate = LocalDate.parse(date, dateFormat);

                    // Have to check if exists in Hashmap && print possible teams to play
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
                    scanner.nextLine();
                    // Need to Validate Integer
                    System.out.println("Enter Scored Goals for " + visitorClubInput + ":");
                    int visitorScoredGoals = scanner.nextInt();
                    scanner.nextLine();

                    addPlayedMatch(homeClubInput, visitorClubInput, matchDate, homeScoredGoals, visitorScoredGoals);
                    break;

                case "S":
                    if (premierLeagueClubs != null){
                        saveData();
                    }else {
                        System.out.println("No Data to Save. Please Try Again!");
                    }
                    break;

                case "E":
                    exitProgram = true;
                    break;

                default:
                    System.out.println("Invalid Option. Please Try Again!");
            }
        }
    }

    public static void main(String[] args) {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.mainMenu();
    }
}
