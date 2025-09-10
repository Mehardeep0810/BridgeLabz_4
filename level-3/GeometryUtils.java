package Assigned4.level3;

import java.util.Scanner;

public class GeometryUtils {

    // Method to calculate Euclidean distance
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    // Method to calculate slope and y-intercept of the line
    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            throw new IllegalArgumentException("Slope is undefined for vertical lines (x1 == x2).");
        }
        double m = (y2 - y1) / (x2 - x1); // slope
        double b = y1 - m * x1;           // y-intercept
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input coordinates
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        scanner.close();

        // Calculate and display distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance between points: %.2f%n", distance);

        // Calculate and display line equation
        try {
            double[] line = calculateLineEquation(x1, y1, x2, y2);
            System.out.printf("Equation of the line: y = %.2fx + %.2f%n", line[0], line[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
