package Assigned4.level1;

import java.util.Scanner;

public class ChocolateDivider {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numberOfChocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter numberOfChildren: ");
        int numberOfChildren = scanner.nextInt();
        scanner.close();

        if (numberOfChildren == 0) {
            System.out.println("Cannot divide by zero children.");
            return;
        }

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        System.out.println("Each child gets " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
        
    }
}