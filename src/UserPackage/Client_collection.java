package UserPackage;

import System.*;

import java.util.List;
import java.util.Scanner;

import System.BankAuthenticator;

public class Client_collection extends Collection {
    Scanner scanner = new Scanner(System.in);

    //sync with bank api

    public void sync_with_bank_api(Client current_Client, BankAuthenticator ba) {

        scanner.nextLine();
        System.out.print("Enter card number: ");
        String card_num = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (ba.authenticate(username, password, card_num)) {
            System.out.println("Syncing with the bank API for account: " + card_num);
            current_Client.bankAccount.setBalance(0);
            current_Client.bankAccount.setCardNum(card_num);
            current_Client.bankAccount.setUserName(username);
            current_Client.bankAccount.setBankBass(password);
            current_Client.bankAccount.setActive(true);
            System.out.println("Sync successful.");
        }
    }

    public double inquire_bank_balance(BankAccount account) {
        return account.getBalance();
    }

    public double inquire_wallet_balance(WalletAccount account) {
        return account.getBalance();
    }

    public void pay_bill(double amount, Client x) {
        if (amount < 0) {
            System.out.println("Error: Bill amount must be non-negative.");
            return;
        }
        System.out.println("Enter the 1 if u want to use your bank acc and 2 for wallet acc");
        int choice = scanner.nextInt();
        if (choice == 1) {
            if (!x.bankAccount.isActive()) {
                System.out.println("You don't have a bank account");
                return;
            } else {
                if (amount <= x.bankAccount.getBalance()) {
                    x.bankAccount.setBalance(x.bankAccount.getBalance() - amount);
                    System.out.println("Bill payment successful. Updated balance: $" + x.bankAccount.getBalance());
                } else
                    System.out.println("Error: Insufficient funds to pay the bill.");
            }
        } else if (choice == 2) {
            if (!x.walletAccount.isActive()) {
                System.out.println("You don't have a wallet account");
                return;
            } else {
                if (amount <= x.walletAccount.getBalance()) {
                    x.walletAccount.setBalance(x.walletAccount.getBalance() - amount);
                    System.out.println("Bill payment successful. Updated balance: $" + x.walletAccount.getBalance());
                } else
                    System.out.println("Error: Insufficient funds to pay the bill.");
            }
        }
    }


    public void withdraw(Client current_Client, double amount, BankAuthenticator ba) {
        AccountType type;
        int choice;
        System.out.println("Enter the 1 if u want to use your bank acc and 2 for wallet acc");
        choice = scanner.nextInt();
        if (choice == 1) {
            if (!current_Client.bankAccount.isActive()) {
                System.out.println("You don't have a bank account");
                return;
            } else {
                ba.withdraw_money(current_Client.bankAccount, amount);
                current_Client.bankAccount.setBalance(current_Client.bankAccount.getBalance() + amount);
            }
        }
        if (choice == 2) {
            if (!current_Client.walletAccount.isActive()) {
                System.out.println("You don't have a wallet account");
                return;
            } else {
                if (current_Client.walletAccount.withdraw(amount)){
                    System.out.println("Withdrawal successful. Updated balance: $" + current_Client.walletAccount.getBalance());
                }
                else
                    System.out.println("Error: Insufficient funds to withdraw the specified amount.");
            }
        }
    }

    public void deposit(Client X, double amount) {
        if (amount < 0) {
            System.out.println("Error: Deposit amount must be non-negative.");
            return;
        }
        System.out.println("Enter the 1 if u want to use your bank acc and 2 for wallet acc");
        int choice = scanner.nextInt();
        if (choice == 1) {
            if (!X.bankAccount.isActive()) {
                System.out.println("You don't have a bank account");
                return;
            } else {
                X.bankAccount.setBalance(X.bankAccount.getBalance() + amount);
                System.out.println("Deposit successful. Updated balance: $" + X.bankAccount.getBalance());
            }
        } else if (choice == 2) {
            if (!X.walletAccount.isActive()) {
                System.out.println("You don't have a wallet account");
                return;
            } else {
                X.walletAccount.setBalance(X.walletAccount.getBalance() + amount);
                System.out.println("Deposit successful. Updated balance: $" + X.walletAccount.getBalance());
            }
        }
    }
    //transfer money from one account to another
    public void transfer_money(Client Source, Client Target, double amount) {
        if (amount < 0) {
            System.out.println("Error: Transfer amount must be non-negative.");
            return;
        }
        System.out.println("Enter the 1 if u want to use your bank acc and 2 for wallet acc");
        int choice = scanner.nextInt();
        if (choice == 1) {
            if (!Source.bankAccount.isActive()) {
                System.out.println("You don't have a bank account");
                return;
            } else {
                if (amount <= Source.bankAccount.getBalance()) {
                    Source.bankAccount.setBalance(Source.bankAccount.getBalance() - amount);
                    Target.bankAccount.setBalance(Target.bankAccount.getBalance() + amount);
                    System.out.println("Transfer successful. Updated balance: $" + Source.bankAccount.getBalance());
                } else
                    System.out.println("Error: Insufficient funds to transfer the specified amount.");
            }
        } else if (choice == 2) {
            if (!Source.walletAccount.isActive()) {
                System.out.println("You don't have a wallet account");
                return;
            } else {
                if (amount <= Source.walletAccount.getBalance()) {
                    Source.walletAccount.setBalance(Source.walletAccount.getBalance() - amount);
                    Target.walletAccount.setBalance(Target.walletAccount.getBalance() + amount);
                    System.out.println("Transfer successful. Updated balance: $" + Source.walletAccount.getBalance());
                } else
                    System.out.println("Error: Insufficient funds to transfer the specified amount.");
            }
        }
    }



    public void run(Client account, BankAuthenticator ba, WalletAuthenticator wa, List<Client> clients) {

        System.out.println("Choose an action:");
        System.out.println("1. Synchronize with bank API");
        System.out.println("2. Inquire balance");
        System.out.println("3. Pay bill");
        System.out.println("4. Withdraw");
        System.out.println("5. Deposit");
        System.out.println("6. Transfer money");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> sync_with_bank_api(account, ba);
            case 2 -> System.out.println("Current balance: $" + inquire_balance(account));
            case 3 -> {
                System.out.println("Enter bill amount:");
                double billAmount = scanner.nextDouble();
                pay_bill(billAmount, account);
            }
            case 4 -> {
                System.out.println("Enter withdrawal amount:");
                double withdrawalAmount = scanner.nextDouble();
                withdraw(account, withdrawalAmount, ba);
            }
            case 5 -> {
                System.out.println("Enter deposit amount:");
                double depositAmount = scanner.nextDouble();
                deposit(account, depositAmount);
            }
            case 6 -> {
               //transfer money from one account to another
                System.out.println("Enter the amount you want to transfer:");
                double transferAmount = scanner.nextDouble();
                System.out.println("Enter the account number of the target account:");
                String targetAccountNumber = scanner.next();
                Client targetAccount = null;
                for (Client client : clients) {
                    if (client.bankAccount.getCardNum().equals(targetAccountNumber)) {
                        targetAccount = client;
                        break;
                    }
                }
                if (targetAccount == null) {
                    System.out.println("Error: Target account not found.");
                    return;
                }
                transfer_money(account, targetAccount, transferAmount);
            }
            default -> System.out.println("Invalid choice. Please choose a valid action.");
        }
    }

    private double inquire_balance(Client account) {
        x:
        System.out.println("Enter the 1 if u want to use your bank acc and 2 for wallet acc");
        int choice = scanner.nextInt();
        if (choice == 1) {
            if (!account.bankAccount.isActive()) {
                System.out.println("You don't have a bank account");
                return 0;
            } else {
                return account.bankAccount.getBalance();
            }
        }
        else if (choice == 2) {
            if (!account.walletAccount.isActive()) {
                System.out.println("You don't have a wallet account");
                return 0;
            } else {
                return account.walletAccount.getBalance();
            }
        }
        else{
            System.out.println("Invalid choice. Please choose a valid action.");
            return 0;
        }
    }
}
