package UserPackage;

import UserPackage.WalletAccount;

public class WalletDatabase {
    private final WalletAccount[] accounts;

    public WalletDatabase(WalletAccount[] account) {
        accounts = new WalletAccount[100];
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
