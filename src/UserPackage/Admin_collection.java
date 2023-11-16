package UserPackage;

import java.util.*;

public class Admin_collection extends Collection {

    private void delete_user(List<User> users, User userToDelete) {
        users.remove(userToDelete);
        System.out.println("User deleted: " + userToDelete.getName());
    }

    private void delete_user(User user) {
        System.out.println("User deleted: " + user.getName());
    }

    private void edit_user(User user, String newName, String newType, String[] newPermissions) {
        user.setName(newName);
        user.setType(newType);
        user.setPermissions(newPermissions);
        System.out.println("Editing user: " + user.getName());
    }

    private void show_users(List<Client> users) {
        System.out.println("List of users:");

        for (Client user : users) {
            // print client data
            System.out.println("User ID: " + user.getUserId());
            System.out.println("User name: " + user.getName());
        }
    }

    private void show_user_data(User user) {
        user.x.viewProfile(user);
    }

    private Client findUserByid(List<Client> users, int id) {
        for (Client user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    private User findClientById(List<Client> users, int id) {
        for (Client user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    private void editAccount(List<Client> clients) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client ID to edit:");
        int id = scanner.nextInt();

        Client clientToEdit = (Client) findClientById(clients, id);

        if (clientToEdit != null) {
            System.out.println("Editing account for client: " + clientToEdit.getName());
            System.out.println("Choose account type:");
            System.out.println("1. Bank Account");
            System.out.println("2. Wallet Account");

            int accountChoice = scanner.nextInt();

            switch (accountChoice) {
                case 1 -> {
                    if (clientToEdit.bankAccount.isActive()) {
                        editBankAccount(clientToEdit.bankAccount);
                    } else {
                        System.out.println("Client does not have a bank account.");
                    }
                }
                case 2 -> {
                    if (clientToEdit.walletAccount.isActive()) {
                        editWalletAccount(clientToEdit.walletAccount);
                    } else {
                        System.out.println("Client does not have a wallet account.");
                    }
                }
                default -> System.out.println("Invalid account choice.");
            }
        } else {
            System.out.println("Client not found.");
        }

        scanner.close();
    }

    private void editBankAccount(BankAccount bankAccount) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Editing Bank Account:");
        System.out.println("1. Edit Card Number");
        System.out.println("2. Edit User Name");
        System.out.println("3. Edit Bank Name");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter new Card Number:");
                String newCardNum = scanner.next();
                bankAccount.setCardNum(newCardNum);
                System.out.println("Card Number updated.");
            }
            case 2 -> {
                System.out.println("Enter new User Name:");
                String newUserName = scanner.next();
                bankAccount.setUserName(newUserName);
                System.out.println("User Name updated.");
            }
            case 3 -> {
                System.out.println("Enter new Bank Name:");
                String newBankName = scanner.next();
                bankAccount.setBankBass(newBankName);
                System.out.println("Bank Name updated.");
            }
            default -> System.out.println("Invalid choice.");
        }

        scanner.close(); // Close the scanner
    }

    private void editWalletAccount(WalletAccount walletAccount) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Editing Wallet Account:");
        System.out.println("1. Edit Balance");
        System.out.println("2. Edit Wallet Provider");
        System.out.println("3. Edit Wallet Account Number");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter new Balance:");
                double newBalance = scanner.nextDouble();
                walletAccount.setBalance(newBalance);
                System.out.println("Balance updated.");
            }
            case 2 -> {
                System.out.println("Enter new Wallet Provider:");
                String newWalletProvider = scanner.next();
                walletAccount.setWalletProvider(newWalletProvider);
                System.out.println("Wallet Provider updated.");
            }
            case 3 -> {
                System.out.println("Enter new Wallet Account Number:");
                int newWalletAccountNumber = scanner.nextInt();
                walletAccount.setWalletAccountNumber(newWalletAccountNumber);
                System.out.println("Wallet Account Number updated.");
            }
            default -> System.out.println("Invalid choice.");
        }

        scanner.close(); // Close the scanner
    }


    public List<Client> run(List<Client> users) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an action:");
        System.out.println("1. Delete user");
        System.out.println("2. Edit user");
        System.out.println("3. Edit user account");
        System.out.println("4. Show users");
        System.out.println("5. Show user data");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter user name to delete:");
                int id = scanner.nextInt();
                Client userToDelete = findUserByid(users, id);
                if (userToDelete != null) {
                    users.remove(userToDelete);
                } else {
                    System.out.println("User not found.");
                }
            }
            case 2 -> {
                System.out.println("Enter user name to edit:");
                int id = scanner.nextInt();
                User userToEdit = findUserByid(users, id);
                if (userToEdit != null) {
                    System.out.println("Enter new name:");
                    String newName = scanner.next();
                    System.out.println("Enter new type:");
                    String newType = scanner.next();
                    edit_user(userToEdit, newName, newType, null);
                } else {
                    System.out.println("User not found.");
                }
            }
            case 3 -> {

            }
            case 4 -> show_users(users);
            case 5 -> {
                System.out.println("Enter user name to show data:");
                int id = scanner.nextInt();
                User userToShowData = findUserByid(users, id);
                if (userToShowData != null) {
                    show_user_data(userToShowData);
                } else {
                    System.out.println("User not found.");
                }
            }
            default -> System.out.println("Invalid choice. Please choose a valid action.");
        }
        return users;
    }


}
