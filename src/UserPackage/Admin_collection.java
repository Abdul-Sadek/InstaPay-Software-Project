package UserPackage;

import java.util.List;
import java.util.Scanner;

public class Admin_Collection extends Collection {

    private void deleteUser(List<User> users, User userToDelete) {
        users.remove(userToDelete);
        System.out.println("User deleted: " + userToDelete.getName());
    }

    private void editUser(User user, String newName, String newType) {
        user.setName(newName);
        user.setType(newType);
        System.out.println("Editing user: " + user.getName());
    }

    private void showUsers(List<User> users) {
        System.out.println("List of users:");

        for (User user : users) {
            System.out.println("User: " + user.getName() + ", Type: " + user.getType());
        }
    }

    private void showUserData(User user) {
        user.x.viewProfile(user);
    }

    private User findUserById(List<User> users, int id) {
        for (User user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> run(List<User> users) {
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
                System.out.println("Enter user ID to delete:");
                int id = scanner.nextInt();
                User userToDelete = findUserById(users, id);
                if (userToDelete != null) {
                    deleteUser(users, userToDelete);
                } else {
                    System.out.println("User not found.");
                }
            }
            case 2 -> {
                System.out.println("Enter user ID to edit:");
                int id = scanner.nextInt();
                User userToEdit = findUserById(users, id);
                if (userToEdit != null) {
                    System.out.println("Enter new name:");
                    String newName = scanner.next();
                    System.out.println("Enter new type:");
                    String newType = scanner.next();
                    editUser(userToEdit, newName, newType);
                } else {
                    System.out.println("User not found.");
                }
            }
            case 3 -> {
                // Implement case 3 logic
                System.out.println("Editing user account");
            }
            case 4 -> showUsers(users);
            case 5 -> {
                System.out.println("Enter user ID to show data:");
                int id = scanner.nextInt();
                User userToShowData = findUserById(users, id);
                if (userToShowData != null) {
                    showUserData(userToShowData);
                } else {
                    System.out.println("User not found.");
                }
            }
            default -> System.out.println("Invalid choice. Please choose a valid action.");
        }

        scanner.close(); // Close the scanner
        return users;
    }
}
