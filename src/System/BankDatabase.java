package System;

import java.util.Map;

public class BankDatabase {

    private Map<String, Double> accounts;
    public BankDatabase(){
        accounts.put("unmrz1111unmrz123", 2000.0);
        accounts.put("snjml1112snjml123", 5000.0);
        accounts.put("noqb1113noqb123", 12000.0);
        accounts.put("uraq1114uraq123", 20200.0);

    }
    public boolean AccountExist(String Api_key) {
        return accounts.containsKey(Api_key);
    }
    public double getBalance(String Api_key) {
        return accounts.get(Api_key);
    }
    public boolean updateBalance(String Api_key, double amount) {
        if (AccountExist(Api_key)) {
            double currentBalance = accounts.get(Api_key);

            if (amount > currentBalance) {
                System.out.println("Not enough funds in the account.");
                return false;
            } else {
                double newBalance = currentBalance - amount;
                accounts.put(Api_key, newBalance);
                System.out.println("Successful operation. New balance in bank: " + newBalance);
                return true;
            }
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }
}

