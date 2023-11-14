package UserPackage;
import System.BankAuthenticator;
import java.util.Scanner;
import System.BankAuthenticator;
public class Client_collection extends Collection {
    BankAuthenticator ba;
    Client current_Client;
    public Client_collection(BankAuthenticator ba){
        this.ba=ba;
    }
    public void sync_with_bank_api(Account account) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter card number: ");
        String card_num = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (ba.authenticate(username, password, card_num)) {
            System.out.println("Syncing with the bank API for account: " + card_num);
            for (Account acc : current_Client.getAccounts()) {
                if (acc.getType() == AccountType.NORMAL_ACCOUNT) {
                    BankAccount ba=new BankAccount(acc.getMobileNumber(),acc.getEmail(),acc.getPassword(),AccountType.BANK_ACCOUNT,card_num,username,password);
                    current_Client.Add_Acc(ba);
                    break;
                }
            }


            // Add your synchronization logic here
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

        account.setBalance(account.getBalance() - amount);

        System.out.println("Bill payment successful. Updated balance: $" + account.getBalance());
    }


    public void withdraw(double amount) {
//        if (amount < 0) {
//            System.out.println("Error: Withdrawal amount must be non-negative.");
//            return;
//        }
//
//        if (amount > account.getBalance()) {
//            System.out.println("Error: Insufficient funds to withdraw the specified amount.");
//            return;
//        }
//
//        account.setBalance(account.getBalance() - amount);
//
//        System.out.println("Withdrawal successful. Updated balance: $" + account.getBalance());
    }

    public void deposit(Account account, double amount) {
        if (amount < 0) {
            System.out.println("Error: Deposit amount must be non-negative.");
            return;
        }

        double currentBalance = account.getBalance();

        account.setBalance(currentBalance + amount);

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an action:");
        System.out.println("1. Synchronize with bank API");
        System.out.println("2. Inquire balance");
        System.out.println("3. Pay bill");
        System.out.println("4. Withdraw");
        System.out.println("5. Deposit");
        System.out.println("6. Transfer money");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> sync_with_bank_api(account);
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
                Account destinationAccount = new Account("DestinationMobileNumber", "destination@example.com", "destination_password", AccountType.BANK_ACCOUNT);
                transfer_money(transferAmount, account, destinationAccount);
            }
            default -> System.out.println("Invalid choice. Please choose a valid action.");
        }
    }
}
