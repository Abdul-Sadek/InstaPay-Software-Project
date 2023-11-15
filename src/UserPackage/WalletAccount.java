package UserPackage;

public class WalletAccount {
    private double balance;
    private String walletProvider;
    private int walletAccountNumber;
    private AccountType type;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    // Default constructor
    public WalletAccount() {
        this.balance = 0;
        this.walletProvider = "";
        this.walletAccountNumber = 0;
        this.type = AccountType.WALLET;
        this.isActive = true; // Assuming a new wallet account is active by default
    }

    // Parameterized constructor
    public WalletAccount(double balance, String walletProvider, int walletAccountNumber, boolean isActive) {
        this.balance = balance;
        this.walletProvider = walletProvider;
        this.walletAccountNumber = walletAccountNumber;
        this.type = AccountType.WALLET;
        this.isActive = isActive;
    }

    // Getter and setter methods for other fields

    public void print() {
        System.out.println("Wallet Account Information:");
        System.out.println("Balance: " + balance);
        System.out.println("Wallet Provider: " + walletProvider);
        System.out.println("Wallet Account Number: " + walletAccountNumber);
        System.out.println("Account Type: " + type);
        System.out.println("Active: " + isActive);
    }
}
