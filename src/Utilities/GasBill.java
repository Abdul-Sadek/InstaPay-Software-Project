package Utilities;

import Utilities.UserPackage.Client;

public class GasBill extends Bill{

   // Constructor
    // parameterized constructor
    public GasBill(double amount, BillType type, String date, double generator, Client receiver, boolean isPaid) {
        super(amount, type, date, generator, receiver, isPaid);
    }
    @Override
    public double calculateBill() {
        return amount*generatorTax;
    }
}
