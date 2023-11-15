package UserPackage;

public class BankAccount {
    private String cardNum;
    private String userName;
    private String bankBass;
    private boolean isActive;
    private double balance;
    private AccountType type;

    // Default constructor
    public BankAccount() {
        super();
        this.cardNum = "";
        this.userName = "";
        this.bankBass = "";
        this.isActive = false; // Default value for isActive
    }

    // Parameterized constructor
    public BankAccount(String mobileNumber, String password, String name, String email, String cardNum, String userName, String bankBass) {
        this.cardNum = cardNum;
        this.userName = userName;
        this.bankBass = bankBass;
        this.isActive = true; // Assuming a new bank account is active by default
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getUserName() {
        return userName;
    }

    public String getBankBass() {
        return bankBass;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setter methods
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBankBass(String bankBass) {
        this.bankBass = bankBass;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    // Getter methods
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void print() {
        System.out.println("Bank Account Information:");
        System.out.println("Card Number: " + cardNum);
        System.out.println("Username: " + userName);
        System.out.println("Bank Name: " + bankBass);
        System.out.println("Balance: " + getBalance());
        System.out.println("Active: " + isActive);
        System.out.println("-------------------------------");
    }
}
