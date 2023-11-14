package Utilities;

public class GasBill extends Bill{

   // Constructor
    public GasBill() {
        this.generatorTax = 5.5;
    }
    @Override
    public double calculateBill() {
        return amount*generatorTax;
    }
}
