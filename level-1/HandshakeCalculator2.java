package Assigned4.level1;

import java.util.Scanner;

public class HandshakeCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numberOfStudents: ");
        int numberOfStudents = scanner.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("Maximum number of handshakes: " + handshakes);
        scanner.close();
    }
}