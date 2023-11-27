package System;

import Utilities.UserPackage.Admin;
import Utilities.UserPackage.Client;

import java.util.Scanner;

public class Instapay_system {
    private BankAuthenticator authenticator;
    private DataBase db;
    private RegisterationValidator registerationValidator;
    private API_System api;
    private Client client;
    private Admin admin;


    //registeration
    public void Register() {
        System.out.println("..........");
        System.out.println("Enter 1 to register as client, 2 to register as admin:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            db.addClient(RegisterationValidator.Register_client(db.getClients()));
        } else if (choice == 2) {
            db.addAdmin(RegisterationValidator.Register_admin(db.getAdmins()));
        } else {
            System.out.println("Invalid choice");
        }
    }
    //login
    public void Login() {
        System.out.println("..........");
        System.out.println("Enter 1 to login as client, 2 to login as admin:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            Client user = RegisterationValidator.Login_client(db.getClients());
            if (user != null) {
                System.out.println("Login successful");
                client = user;
            } else {
                System.out.println("Login failed");
            }
        } else if (choice == 2) {
            Admin user = RegisterationValidator.Login_admin(db.getAdmins());
            if (user != null) {
                System.out.println("Login successful");
                admin = user;
            } else {
                System.out.println("Login failed");
            }
        } else {
            System.out.println("Invalid choice");
        }
    }
    public void Logout() {
        System.out.println("..........");
        System.out.println("Enter 1 to logout as client, 2 to logout as admin:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            client = null;
        } else if (choice == 2) {
            admin = null;
        } else {
            System.out.println("Invalid choice");
        }
    }
    public void run(){
        while (true) {
            System.out.println("..........");
            System.out.println("Enter 1 to register, 2 to login, 3 to logout,4 Display fuctionalities 4 5 to exit:");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                Register();
            } else if (choice == 2) {
                Login();
            } else if (choice == 3) {
                Logout();
            }
            else if (choice == 4) {
                if(client !=null){
                    client.functionalities.run(client,authenticator,new WalletAuthenticator(),db.getClients());
                }
                else if(admin !=null){
                    admin.functionalities.run(db.getClients());
                }
            }
            else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public Instapay_system(API_System api, DataBase db) {
        this.api =api ;
        this.authenticator = new BankAuthenticator(api);
        this.db = db;

    }


}
