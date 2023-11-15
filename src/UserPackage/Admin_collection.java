package UserPackage;

import java.util.*;

public class Admin_collection extends Collection {

    private void delete_user(List<User> users, User userToDelete) {
        users.remove(userToDelete);
        System.out.println("User deleted: " + userToDelete.getName());
    }
    private void delete_user( User user) {
        System.out.println("User deleted: " + user.getName());
    }

    private void edit_user( User user, String newName, String newType, String[] newPermissions) {
        user.setName(newName);
        user.setType(newType);
        user.setPermissions(newPermissions);
        System.out.println("Editing user: " + user.getName());
    }



    private void show_users(List<User> users) {
        System.out.println("List of users:");

        for (User user : users) {
            System.out.println("User: " + user.getName() + ", Type: " + user.getType());
        }
    }

    private void show_user_data(User user) {
        user.x.viewProfile(user);
    }

    private User findUserByid(List<User> users, int id) {
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
                System.out.println("Enter user name to delete:");
                int id = scanner.nextInt();
                User userToDelete = findUserByid(users, id);
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
