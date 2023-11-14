package Utilities;

import UserPackage.User;

public class WaterBill extends Bill{
    // Constructor
    public WaterBill() {
        this.generatorTax = 2.0;
    }
    @Override
    public double calculateBill() {
        return amount*generatorTax;
    }
}
