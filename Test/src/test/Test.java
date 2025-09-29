package test;

public class Test {
    public static void main(String[] args) {
        // Define stadium names
        String[] stadiums = {"Kingsmead", "St Georges", "Wanderers"};
        
        // Define batsman names
        String[] batsmen = {"Jacques Kallis", "Hashim Amla", "AB De Villiers"};
        
        // Two-dimensional array: [stadium][batsman]
        // Each row represents a stadium, each column represents a batsman
        int[][] runs = {
            {5000, 3800, 4200},  // Kingsmead
            {3500, 3700, 3900},  // St Georges
            {6200, 5000, 5200}   // Wanderers
        };
        
        // Calculate total runs per batsman
        int[] batsmanTotals = new int[3];
        for (int batsman = 0; batsman < 3; batsman++) {
            int total = 0;
            for (int stadium = 0; stadium < 3; stadium++) {
                total += runs[stadium][batsman];
            }
            batsmanTotals[batsman] = total;
        }
        
        // Calculate total runs per stadium and find highest
        int[] stadiumTotals = new int[3];
        int highestStadiumIndex = 0;
        int highestStadiumRuns = 0;
        
        for (int stadium = 0; stadium < 3; stadium++) {
            int total = 0;
            for (int batsman = 0; batsman < 3; batsman++) {
                total += runs[stadium][batsman];
            }
            stadiumTotals[stadium] = total;
            
            // Check if this is the highest
            if (total > highestStadiumRuns) {
                highestStadiumRuns = total;
                highestStadiumIndex = stadium;
            }
        }
        
        // Display the report
        System.out.println("===============================================");
        System.out.println("    BATSMEN CAREER RUNS REPORT BY STADIUM");
        System.out.println("===============================================\n");
        
        // Display runs for each stadium
        for (int stadium = 0; stadium < 3; stadium++) {
            System.out.println(stadiums[stadium] + ":");
            for (int batsman = 0; batsman < 3; batsman++) {
                System.out.println("  " + batsmen[batsman] + ": " + runs[stadium][batsman] + " runs");
            }
            System.out.println("  Stadium Total: " + stadiumTotals[stadium] + " runs");
            System.out.println();
        }
        
        // Display career totals for each batsman
        System.out.println("-----------------------------------------------");
        System.out.println("CAREER TOTALS:");
        System.out.println("-----------------------------------------------");
        for (int batsman = 0; batsman < 3; batsman++) {
            System.out.println(batsmen[batsman] + ": " + batsmanTotals[batsman] + " runs");
        }
        
        // Display highest scoring stadium
        System.out.println("\n===============================================");
        System.out.println("HIGHEST RUNS SCORED PER STADIUM:");
        System.out.println(stadiums[highestStadiumIndex] + " with " + highestStadiumRuns + " total runs");
        System.out.println("===============================================");
    }
}