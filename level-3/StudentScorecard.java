package Assigned4.level3;

import java.util.Scanner;

public class StudentScorecard {

    // Method to generate random 2-digit PCM scores
    public static int[][] generatePCMScores(int studentCount) {
        int[][] scores = new int[studentCount][3]; // [Physics, Chemistry, Math]
        for (int i = 0; i < studentCount; i++) {
            scores[i][0] = (int)(Math.random() * 50) + 50; // Physics
            scores[i][1] = (int)(Math.random() * 50) + 50; // Chemistry
            scores[i][2] = (int)(Math.random() * 50) + 50; // Math
        }
        return scores;
    }

    // Method to calculate total, average, and percentage
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // [Total, Average, Percentage]
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Method to display the scorecard
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("S%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\n",
                    i + 1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();

        int[][] scores = generatePCMScores(studentCount);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
        scanner.close();
    }
}
