package Utilities.UserPackage;

public class AdminAccount {
    private int adminID;
    private int accountNumber;
    private AccountType type;

    public AdminAccount() {
        this.adminID = 1;
        this.accountNumber = 1;
        this.type = AccountType.ADMIN;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAdminID() {
        return adminID;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public AccountType getType() {
        return type;
    }
}
