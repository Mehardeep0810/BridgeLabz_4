package Assigned4.level3;

public class NumberChecker3 {

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

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = freq[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 1729;

        int digitCount = countDigits(number);
        int[] digits = extractDigits(number);
        int sum = sumOfDigits(digits);
        double squareSum = sumOfSquares(digits);
        boolean isHarshad = isHarshadNumber(number, digits);
        int[][] frequency = digitFrequency(digits);

        System.out.println("Number: " + number);
        System.out.println("Digit Count: " + digitCount);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println("\nSum of Digits: " + sum);
        System.out.printf("Sum of Squares: %.2f%n", squareSum);
        System.out.println("Harshad Number: " + (isHarshad ? "Yes" : "No"));
        System.out.println("Digit Frequencies:");
        for (int[] pair : frequency) {
            if (pair[1] > 0) {
                System.out.println("Digit " + pair[0] + ": " + pair[1] + " time(s)");
            }
        }
    }
}
