

import java.util.InputMismatchException;
import java.util.Scanner;

// ICricket.java (inlined)
interface ICricket {
    String getBatsman();
    String getStadium();
    int getRunsScored();
}

// Cricket.java (inlined)
abstract class Cricket implements ICricket {
    protected String batsman;
    protected String stadium;
    protected int runsScored;

    // Constructor
    public Cricket(String batsman, String stadium, int runsScored) {
        this.batsman = batsman;
        this.stadium = stadium;
        this.runsScored = runsScored;
    }

    // Getters required by ICricket
    @Override
    public String getBatsman() {
        return batsman;
    }

    @Override
    public String getStadium() {
        return stadium;
    }

    @Override
    public int getRunsScored() {
        return runsScored;
    }

    // Optionally, subclasses can implement additional behavior
}

// CricketRunsScored.java (inlined)
class CricketRunsScored extends Cricket {

    // Constructor that passes values to the abstract superclass
    public CricketRunsScored(String batsman, String stadium, int runsScored) {
        super(batsman, stadium, runsScored);
    }

    // Method to print the report
    public void printReport() {
        System.out.println();
        System.out.println("=== Batsman Runs Report ===");
        System.out.println("Batsman : " + getBatsman());
        System.out.println("Stadium : " + getStadium());
        System.out.println("Total Runs Scored at this stadium (career): " + getRunsScored());
        System.out.println("===========================");
    }
}

// Public class with main — name must match file name (CricketApp.java)
public class CricketApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter batsman's name: ");
            String batsman = scanner.nextLine().trim();
            if (batsman.isEmpty()) batsman = "Unknown Batsman";

            System.out.print("Enter stadium name: ");
            String stadium = scanner.nextLine().trim();
            if (stadium.isEmpty()) stadium = "Unknown Stadium";

            int runs = 0;
            while (true) {
                System.out.print("Enter total runs scored (integer): ");
                try {
                    runs = scanner.nextInt();
                    break;
                } catch (InputMismatchException ime) {
                    System.out.println("Please enter a valid integer for runs.");
                    scanner.nextLine(); // clear invalid input
                }
            }

            CricketRunsScored report = new CricketRunsScored(batsman, stadium, runs);
            report.printReport();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
