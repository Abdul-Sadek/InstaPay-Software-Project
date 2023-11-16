package Utilities;

import UserPackage.Client;

public class ElectricityBill extends Bill{

    // parameterized constructor
    public ElectricityBill(double amount, BillType type, String date, double generator, Client receiver, boolean isPaid) {
        super(amount, type, date, generator, receiver, isPaid);
    }

    public double calculateBill() {
        return amount*generatorTax;
    }
}
