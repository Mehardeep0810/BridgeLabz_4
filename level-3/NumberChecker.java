package Assigned4.level3;

import java.util.Scanner;

public class NumberChecker {

    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] extractDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    public static int[] findTwoLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findTwoSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        int digitCount = countDigits(number);
        int[] digits = extractDigits(number);

        System.out.println("Digit count: " + digitCount);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();

        System.out.println("Duck Number: " + (isDuckNumber(digits) ? "Yes" : "No"));
        System.out.println("Armstrong Number: " + (isArmstrongNumber(number, digits) ? "Yes" : "No"));

        int[] largestTwo = findTwoLargest(digits);
        System.out.println("Largest digit: " + largestTwo[0]);
        System.out.println("Second largest digit: " + largestTwo[1]);

        int[] smallestTwo = findTwoSmallest(digits);
        System.out.println("Smallest digit: " + smallestTwo[0]);
        System.out.println("Second smallest digit: " + smallestTwo[1]);
        scanner.close();
    }
}
