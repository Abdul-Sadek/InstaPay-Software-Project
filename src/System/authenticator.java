package System;

import Utilities.UserPackage.BankAccount;

public abstract interface authenticator {
    public abstract boolean authenticate(String username,String password,String card_num);
    public abstract boolean withdraw_money(BankAccount bank_acc, double amount);
}
