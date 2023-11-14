package UserPackage;
import java.util.*;
public class Account {
    private String mobileNumber;
    private String email;
    private String password;
    private AccountType type;
    private double balance= 1;

    // Constructor
    public Account(String mobileNumber, String email, String password, AccountType type) {
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
