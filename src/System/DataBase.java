package System;

import UserPackage.Admin;
import UserPackage.Client;
import Utilities.Bill;
import Utilities.BillType;
import Utilities.GasBill;

public class DataBase {
    private final Client[] clients;
    private final Bill[] bills;
    private final String[] systemLogs;
    private final Admin[] admins;

    // initialize the database size
    public DataBase() {
        clients = new Client[100];
        bills = new Bill[100];
        systemLogs = new String[100];
        admins = new Admin[100];

        // Sample clients
        clients[0] = new Client("Ahmed", "ahmed", "123", "Cairo", "01234567890", "hend@mail.com");

        // Sample bills
        bills[0] = new GasBill(100, BillType.ELECTRICITY, "1/1/2021", 0.14, clients[0], true);

        // Sample system logs
        systemLogs[0] = "Log entry 1";
        systemLogs[1] = "Log entry 2";
    }

    // add a client to the database
    public void addClient(Client client) {
        // to find an empty index to add the client to the database
        // this is done to avoid null pointer exception
        for (int i = 0; i < clients.length; i++) {
            // if the current index is empty
            if (clients[i] == null) {
                clients[i] = client;
                break;
            }
        }
    }

    // delete a client from the database
    public void deleteClient(Client client) {
        // to find the client index to delete it from the database
        for (int i = 0; i < clients.length; i++) {
            // if the current index is not empty
            if (clients[i] != null) {
                // if the current index is the client to be deleted
                if (clients[i].equals(client)) {
                    clients[i] = null;
                    break;
                }
            }
        }
    }

    // add a bill to the database
    public void addBill(Bill bill) {
        // to find an empty index to add the bill to the database
        // this is done to avoid null pointer exception
        for (int i = 0; i < bills.length; i++) {
            // if the current index is empty
            if (bills[i] == null) {
                bills[i] = bill;
                break;
            }
        }
    }

    // edit client data in the database
    // passing the client after editing its data
    public void editClient(Client client) {
        // to find the client index to edit it in the database
        for (int i = 0; i < clients.length; i++) {
            // if the current index is not empty
            if (clients[i] != null) {
                // if the current index is the client to be edited
                if (clients[i].equals(client)) {
                    clients[i] = client;
                    break;
                }
            }
        }
    }

    // adding a log to the system logs as a string
    public void addLog(String log) {
        // this is done to avoid null pointer exception
        for (int i = 0; i < systemLogs.length; i++) {
            // if the current index is empty
            if (systemLogs[i] == null) {
                systemLogs[i] = log;
                break;
            }
        }
    }

    // add an admin to the database
    public void addAdmin(Admin admin) {
        for (int i = 0; i < admins.length; i++) {
            // if the current index is empty
            if (admins[i] == null) {
                admins[i] = admin;
                break;
            }
        }
    }
}
