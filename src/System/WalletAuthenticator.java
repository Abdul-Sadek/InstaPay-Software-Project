package System;

import java.util.Scanner;

public class WalletAuthenticator {
    private String generatedOTP;
    Scanner scanner=new Scanner(System.in);
    public void generate_otp(String mobileNumber) {
        generatedOTP = generateFakeOTP();
        System.out.println("OTP sent to " + mobileNumber + ": " + generatedOTP);
    }
    public boolean verifyOTP(String enteredOTP) {
        // Check if the entered OTP matches the generated OTP
        if (enteredOTP.equals(generatedOTP)) {
            System.out.println("OTP verified successfully");
            return true;
        } else {
            System.out.println("Invalid OTP");
            return false;
        }
    }
    private String generateFakeOTP() {
        // Generate a random 6-digit OTP
        int randomOTP = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(randomOTP);
    }
    public boolean authenticate(String mobile) {
        generate_otp(mobile);
        String otp= scanner.nextLine();
        if(verifyOTP(otp)){
            System.out.println("verified successfully");
            return true;
        }
        return false;

    }
}
