package Utilities.UserPackage;

public class Collection {
    public void viewProfile(User user) {
        System.out.println("Username: " + user.getName());
        System.out.println("User ID: " + user.getUserId());
        System.out.println("User Type: " + user.getType());
        System.out.println("Permissions:");
        for (String permission : user.getPermissions()) {
            System.out.println(permission);
        }
    }

    public void viewProfile(Client user) {
        BankAccount account = user.bankAccount;
        WalletAccount acc = user.walletAccount;
        System.out.println("Username: " + user.getName());
        System.out.println("User ID: " + user.getUserId());
        System.out.println("User Type: " + user.getType());
        if (account.isActive()) {
            account.print();
        }
        if(acc.isActive()){
            acc.print();
        }
        System.out.println("Permissions:");
        for (String permission : user.getPermissions()) {
            System.out.println(permission);
        }
    }

}