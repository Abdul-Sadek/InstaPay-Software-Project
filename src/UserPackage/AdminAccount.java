package UserPackage;

public class AdminAccount {
    private int adminID;
    private int accountNumber;
    protected AccountType type;


    public AdminAccount() {
        adminID = 1;
        accountNumber = 1;
        // set the account type to admin
        type = AccountType.ADMIN;
    }
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getAdminID(AdminAccount account) {
        return account.adminID;
    }
    public int getAccountNumber(AdminAccount account) {
        return account.accountNumber;
    }
}
