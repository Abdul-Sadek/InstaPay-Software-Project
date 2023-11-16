package System;

import UserPackage.AccountType;
import UserPackage.Admin;
import UserPackage.Client;

import java.util.List;
import java.util.Scanner;

public interface RegisterationValidator {


    //client registeration
    static Client Register_client(List<Client> users){
        System.out.println("..........");
        System.out.println("Enter username and password to register:");
        Scanner scanner = new Scanner(System.in);
        String username, password;
        username = scanner.nextLine();
        password = scanner.nextLine();
        for (Client user : users) {
            if (user.getName().equals(username) && user.getAccount().getPassword().equals(password)) {
                System.out.println("User already exists");
                return null;
            }
        }
        System.out.println("Enter name, email, address, phone number:");
        String name, email, address, phoneNumber;
        name = scanner.nextLine();
        email = scanner.nextLine();
        address = scanner.nextLine();
        phoneNumber = scanner.nextLine();
        Client user = new Client(username, password, name, email, address, phoneNumber);
        user.getAccount().setName(username);
        user.getAccount().setPassword(password);
        user.getAccount().setEmail(email);
        user.getAccount().setMobileNumber(phoneNumber);
        user.getAccount().setType(AccountType.CLIENT);
        users.add(user);
        System.out.println("User registered successfully");
        return user;
    }
    // admin registeration
    static Admin Register_admin(List<Admin> users){
        System.out.println("..........");
        System.out.println("Enter username and password to register:");
        Scanner scanner = new Scanner(System.in);
        String username, password;
        username = scanner.nextLine();
        password = scanner.nextLine();
        for (Admin user : users) {
            if (user.getName().equals(username) && user.getAccount().getPassword().equals(password)) {
                System.out.println("User already exists");
                return null;
            }
        }
        System.out.println("Enter name, email, address, phone number:");
        String name, email, address, phoneNumber;
        name = scanner.nextLine();
        email = scanner.nextLine();
        Admin user = new Admin(name, username, password);
        users.add(user);
        System.out.println("User registered successfully");
        return user;
    }
   //login admin
    static Admin Login_admin(List<Admin> users){
        System.out.println("..........");
        System.out.println("Enter username and password to login:");
        Scanner scanner = new Scanner(System.in);
        String username, password;
        username = scanner.nextLine();
        password = scanner.nextLine();
        for (Admin user : users) {
            if (user.getName().equals(username) && user.getAccount().getPassword().equals(password)) {
                System.out.println("Login successful");
                return user;
            }
        }
        System.out.println("Login failed");
        return null;
    }
    //login client
    static Client Login_client(List<Client> users){
        System.out.println("..........");
        System.out.println("Enter username and password to login:");
        Scanner scanner = new Scanner(System.in);
        String username, password;
        username = scanner.nextLine();
        password = scanner.nextLine();
        for (Client user : users) {
            if (user.getName().equals(username) && user.getAccount().getPassword().equals(password)) {
                System.out.println("Login successful");
                return user;
            }
        }
        System.out.println("Login failed");
        return null;
    }
}
