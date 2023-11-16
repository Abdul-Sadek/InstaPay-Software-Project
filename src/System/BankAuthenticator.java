package System;


import UserPackage.BankAccount;


public class BankAuthenticator implements authenticator {
    private final API_System sys;
    public BankAuthenticator(API_System sys) {
        this.sys = sys;
    }

    @Override
    public boolean authenticate(String username,String password,String card_num) {
        return sys.checkexist(username, password, card_num);

    }

    @Override
    public boolean withdraw_money(BankAccount bank_acc, double amount) {

        return sys.check_bank(amount, bank_acc.getUserName(), bank_acc.getBankBass(), bank_acc.getCardNum());
    }


}
