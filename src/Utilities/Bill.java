package Utilities;

import UserPackage.User;

public abstract class Bill {
    protected double amount;
    protected BillType type;
    protected String date;
    protected double generatorTax;
    protected User receiver;
    protected boolean isPaid;

    // parameterized constructor
    public Bill(double amount, BillType type, String date, double generator, User receiver, boolean isPaid) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.generatorTax = generator;
        this.receiver = receiver;
        this.isPaid = isPaid;
    }
    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public double getGenerator() {
        return generatorTax;
    }

    public User getReciever() {
        return receiver;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGenerator(double generator) {
        this.generatorTax = generator;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public abstract double calculateBill();
}
