package Assigned4.level1;

import java.util.Scanner;

public class NaturalNumberSum {
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        int result = sumOfNaturalNumbers(number);
        System.out.println("Sum of first " + number + " natural numbers is: " + result);
        scanner.close();
    }
}
