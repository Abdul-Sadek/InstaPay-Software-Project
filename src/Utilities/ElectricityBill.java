package Utilities;

import UserPackage.User;

public class ElectricityBill extends Bill{

    public ElectricityBill() {
        this.generatorTax = 1.5;
    }
    public double calculateBill() {
        return amount*generatorTax;
    }
}
