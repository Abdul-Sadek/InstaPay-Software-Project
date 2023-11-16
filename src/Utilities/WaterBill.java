package Utilities;

import UserPackage.Client;

public class WaterBill extends Bill{
    // parameterized constructor
    public WaterBill(double amount, BillType type, String date, double generator, Client receiver, boolean isPaid) {
        super(amount, type, date, generator, receiver, isPaid);
    }
    @Override
    public double calculateBill() {
        return amount*generatorTax;
    }
}
