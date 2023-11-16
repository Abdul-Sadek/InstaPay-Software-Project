package System;

import UserPackage.BankAccount;

public interface authenticator {
    boolean authenticate(String username,String password,String card_num);
    boolean withdraw_money(BankAccount bank_acc, double amount);
}
