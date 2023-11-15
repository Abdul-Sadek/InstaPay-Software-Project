package UserPackage;

public class WalletAccount {
    private double balance;
    private String walletProvider;
    private int walletAccountNumber;
    protected AccountType type;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }
    public WalletAccount() {
        balance = 0;
        walletProvider = "";
        walletAccountNumber = 0;
        type = AccountType.WALLET;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setWalletProvider(String walletProvider) {
        this.walletProvider = walletProvider;
    }

    public void setWalletAccountNumber(int walletAccountNumber) {
        this.walletAccountNumber = walletAccountNumber;
    }

    // get the wallet provider
    public String getWalletProvider() {
        return walletProvider;
    }

    // get the wallet account number
    public int getWalletAccountNumber() {
        return walletAccountNumber;
    }

    public void print() {
        System.out.println("Wallet Account Information:");
        System.out.println("Balance: " + balance);
        System.out.println("Wallet Provider: " + walletProvider);
        System.out.println("Wallet Account Number: " + walletAccountNumber);
        System.out.println("Account Type: " + type);
    }


}
