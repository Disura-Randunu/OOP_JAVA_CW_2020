import java.util.Scanner;

public class Main {

    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    //Main Menu
    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram){

            System.out.println("Add Football Club            - A");
            System.out.println("Delete Football Club         - D");
            System.out.println("Display Football Club Stats  - S");
            System.out.println("Display Premier League Table - P");
            System.out.println("Exit Program                 - E\n");
            System.out.println("Enter Option: ");

            String option = scanner.nextLine();

            switch (option){
                case "A":
                    premierLeagueManager.addFootballClub();
                    break;
                case "D":
                    premierLeagueManager.deleteFootballClub();
                    break;
                case "S":
                    premierLeagueManager.displayClubStats();
                    break;
                case "P":
                    premierLeagueManager.displayPremierLeagueTable();
                    break;
                case "E":
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid Option. Try Again");
            }
        }

    }
}
