package System;

public class WalletAuthenticator {
    private String generatedOTP; // To store the generated OTP

    // Method to generate a fake OTP and send it to the user's mobile number
    public void authenticate(String mobileNumber) {
        generatedOTP = generateFakeOTP();
        Instapay_system.out.println("OTP sent to " + mobileNumber + ": " + generatedOTP);
    }
    public boolean verifyOTP(String enteredOTP) {
        // Check if the entered OTP matches the generated OTP
        if (enteredOTP.equals(generatedOTP)) {
            Instapay_system.out.println("OTP verified successfully");
            return true;
        } else {
            Instapay_system.out.println("Invalid OTP");
            return false;
        }
    }
    private String generateFakeOTP() {
        // Generate a random 6-digit OTP
        int randomOTP = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(randomOTP);
    }
    public boolean authenticate(String username,String password,String card_num) {
        return verifyOTP(generatedOTP);
    }
}
