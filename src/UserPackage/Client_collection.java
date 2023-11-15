package UserPackage;
import System.BankAuthenticator;

import java.util.Objects;
import java.util.Scanner;
import System.BankAuthenticator;
public class Client_collection extends Collection {
    BankAuthenticator ba;
    Client current_Client;
    Scanner scanner = new Scanner(System.in);

    // default constructor
    public Client_collection() {
        this.current_Client = new Client();
    }

    // constructor
    public Client_collection(Client current_Client){
        this.current_Client=current_Client;
    }
    public Client_collection(BankAuthenticator ba){
        this.ba=ba;
    }
    public void sync_with_bank_api() {

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
            System.out.println("Sync successful.");
        }
    }

    public double inquire_balance(Account account) {
        return account.getBalance();
    }

    public void pay_bill(Account account, double amount) {
        if (amount < 0) {
            System.out.println("Error: Bill amount must be non-negative.");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Error: Insufficient funds to pay the bill.");
            return;
        }

//        BankAccount.setBalance(BankAccount.getBalance() - amount);
//        current_Client.getbankAccounts()

        System.out.println("Bill payment successful. Updated balance: $" + account.getBalance());
    }


    public void withdraw(double amount) {
        AccountType type;
        int choice;
        System.out.println("Enter the 1 if u want to use your bank acc and 2 for wallet acc" );
        choice= scanner.nextInt();
        if(choice==1){
            if(current_Client.bankAccount.getCardNum().equals("")) {
                System.out.println("You don't have a bank account");
                return;
            }
            else {
                ba.withdraw_money(current_Client.bankAccount,amount);
                current_Client.bankAccount.setBalance(current_Client.bankAccount.getBalance() + amount);
            }
        }
    }

    public void deposit(Account account, double amount) {
        if (amount < 0) {
            System.out.println("Error: Deposit amount must be non-negative.");
            return;
        }

        double currentBalance = account.getBalance();

        current_Client.bankAccount.setBalance(currentBalance + amount);

        System.out.println("Deposit successful. Updated balance: $" + account.getBalance());
    }

    public void transfer_money(double amount, Account sourceAccount, Account destinationAccount) {
        if (amount < 0) {
            System.out.println("Error: Transfer amount must be non-negative.");
            return;
        }

        if (amount > sourceAccount.getBalance()) {
            System.out.println("Error: Insufficient funds to transfer the specified amount.");
            return;
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);

        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        System.out.println("Transfer successful. Updated balances - Source: $" + sourceAccount.getBalance() +
                ", Destination: $" + destinationAccount.getBalance());
    }

    public void run(Account account) {

        System.out.println("Choose an action:");
        System.out.println("1. Synchronize with bank API");
        System.out.println("2. Inquire balance");
        System.out.println("3. Pay bill");
        System.out.println("4. Withdraw");
        System.out.println("5. Deposit");
        System.out.println("6. Transfer money");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> sync_with_bank_api();
            case 2 -> System.out.println("Current balance: $" + inquire_balance(account));
            case 3 -> {
                System.out.println("Enter bill amount:");
                double billAmount = scanner.nextDouble();
                pay_bill(account, billAmount);
            }
            case 4 -> {
                System.out.println("Enter withdrawal amount:");
                double withdrawalAmount = scanner.nextDouble();
                withdraw(withdrawalAmount);
            }
            case 5 -> {
                System.out.println("Enter deposit amount:");
                double depositAmount = scanner.nextDouble();
                deposit(account, depositAmount);
            }
            case 6 -> {
                System.out.println("Enter transfer amount:");
                double transferAmount = scanner.nextDouble();
                System.out.println("Enter destination account details:");
                // Simulate getting destination account details (replace this with your actual logic)
                Account destinationAccount = new Account();
                transfer_money(transferAmount, account, destinationAccount);
            }
            default -> System.out.println("Invalid choice. Please choose a valid action.");
        }
    }
}
