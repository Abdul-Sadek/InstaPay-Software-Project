package UserPackage;

import UserPackage.WalletAccount;

public class WalletDatabase {
    private final WalletAccount[] accounts;

    public WalletDatabase(WalletAccount[] account) {
        accounts = new WalletAccount[100];
        // Fill the wallet database with sample accounts
        WalletAccount account1 = new WalletAccount(500.0, "Provider A", 123456, true);
        WalletAccount account2 = new WalletAccount(1000.0, "Provider B", 789012, true);
        WalletAccount account3 = new WalletAccount(250.0, "Provider C", 345678, false);

        // Adding the sample accounts to the database
        addWalletAccount(account1);
        addWalletAccount(account2);
        addWalletAccount(account3);
    }
    // add a wallet account to the database
    public void addWalletAccount(WalletAccount account) {
        for(int i=0; i<accounts.length; i++) {
            if(accounts[i] == null) {
                accounts[i] = account;
                break;
            }
        }
    }
    // delete a wallet account from the database
    public void deleteWalletAccount(WalletAccount account) {
        for(int i=0; i<accounts.length; i++) {
            if(accounts[i] != null) {
                if(accounts[i].equals(account)) {
                    accounts[i] = null;
                    break;
                }
            }
        }
    }
}
