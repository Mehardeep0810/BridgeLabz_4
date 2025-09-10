package Assigned4.level1;

import java.util.Scanner;

public class HandshakeCalculator {
    public static int maxHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = scanner.nextInt();
        int handshakes = maxHandshakes(students);
        System.out.println("Maximum number of handshakes: " + handshakes);
        scanner.close();
    }
}
