package System;


import UserPackage.Account;
import UserPackage.BankAccount;
import UserPackage.Client;

import java.util.*;


public class BankAuthenticator implements authenticator {
    private API_System sys;
    public BankAuthenticator(API_System sys) {
        this.sys = sys;
    }

    @Override
    public boolean authenticate(String username,String password,String card_num) {
        if(sys.checkexist(username,password,card_num)){
            return true;
        }
        return false;

    }

    @Override
    public boolean withdraw_money(BankAccount bank_acc, double amount) {

        if(sys.check_bank(amount,bank_acc.getUserName(),bank_acc.getBankBass(),bank_acc.getCardNum())) {
            return true;
        }
        return false;
    }


}
