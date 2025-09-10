package Assigned4.level3;

import java.util.Arrays;

public class OTPGenerator {

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; 
    }

    public static int[] generateOTPArray(int size) {
        int[] otps = new int[size];
        for (int i = 0; i < size; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }
    
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otpArray = generateOTPArray(10);

        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));

        if (areOTPsUnique(otpArray)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Duplicate OTPs found.");
        }
    }
}