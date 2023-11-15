package System;

import UserPackage.Admin;
import UserPackage.Client;
import UserPackage.User;
import Utilities.*;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private final List<Client> clients;
    private final List<Bill> bills;
    private final List<String> systemLogs;
    private final List<Admin> admins;

    // initialize the database size
    public DataBase() {
        clients = new ArrayList<>();
        bills = new ArrayList<>();
        systemLogs = new ArrayList<>();
        admins = new ArrayList<>();
        // String mobileNumber, String password, String name, String email, String address, String phoneNumber
        Client client1 = new Client("1234567890", "password1", "John Doe", "john@example.com", "123 Main St", "9876543210");
        Client client2 = new Client("9876543210", "password2", "Alice Smith", "alice@example.com", "456 Elm St", "1234567890");
        Client client3 = new Client("1112223333", "password3", "Bob Johnson", "bob@example.com", "789 Oak St", "5556667777");

        // Adding the sample clients to the database
        addClient(client1);
        addClient(client2);
        addClient(client3);

       //  double amount, BillType type, String date, double generator, User receiver, boolean isPaid
        Bill bill1 = new GasBill(100, BillType.GAS, "2021-01-01", 0.1, client1, false);
        Bill bill2 = new WaterBill(200, BillType.WATER, "2021-01-01", 0.2, client2, false);
        Bill bill3 = new ElectricityBill(300, BillType.GAS, "2021-01-01", 0.3, client3, false);
        // Adding the sample bills to the database
        addBill(bill1);
        addBill(bill2);
        addBill(bill3);

        // Filling system logs with sample data
        addLog("System initialized.");
        addLog("Client data loaded.");
        addLog("Bills data loaded.");
        addLog("Admins data loaded.");

        // Any other relevant log entries based on system events or actions
        addLog("User authentication module updated.");
        addLog("New bill generated.");
        addLog("System maintenance scheduled for next week.");


        // Sample admins with attributes: (name, username, password)
        Admin admin1 = new Admin("Admin1", "Admin55", "admin5632");
        Admin admin2 = new Admin("Admin 2", "admin63", "admin5847");

        // Adding the sample admins to the database
        addAdmin(admin1);
        addAdmin(admin2);
    }

    // add a client to the database
    public void addClient(Client client) {
        clients.add(client);
    }

    // delete a client from the database
    public void deleteClient(Client client) {
        clients.remove(client);
    }

    // add a bill to the database
    public void addBill(Bill bill) {
        bills.add(bill);
    }

    // edit client data in the database
    // passing the client after editing its data
    public void editClient(Client client) {
        int index = clients.indexOf(client);
        if (index != -1) {
            clients.set(index, client);
        }
    }

    // adding a log to the system logs as a string
    public void addLog(String log) {
        systemLogs.add(log);
    }

    // add an admin to the database
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public List<Client> getClients() {
        return new ArrayList<>(clients);
    }

    public List<Bill> getBills() {
        return new ArrayList<>(bills);
    }

    public List<String> getSystemLogs() {
        return new ArrayList<>(systemLogs);
    }

    public List<Admin> getAdmins() {
        return new ArrayList<>(admins);
    }
}
