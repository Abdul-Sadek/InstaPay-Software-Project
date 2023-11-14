package UserPackage;

public class WalletAccount {
    private double balance;
    private String walletProvider;
    private int walletAccountNumber;
    protected AccountType type;

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
    // get the balance of the wallet
    public double getBalance(WalletAccount account) {
        return account.balance;
    }
    // get the wallet provider
    public String getWalletProvider(WalletAccount account) {
        return account.walletProvider;
    }
    // get the wallet account number
    public int getWalletAccountNumber(WalletAccount account) {
        return account.walletAccountNumber;
    }
}
