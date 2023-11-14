package System;

public class API_System {
    BankDatabase Bank;

    public API_System(BankDatabase ba){
        Bank=ba;
    }
    public boolean checkexist(String user_n,String pass,String card_num){
        if(Bank.AccountExist(generate_api_key(user_n,pass,card_num))){
            return true;
        }
        return false;
    }
    public String generate_api_key(String user_n,String pass,String card_num){
        String input=user_n+card_num+pass;
        return rot13(input);
    }
    public static String rot13(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            sb.append(c);
        }
        return sb.toString();
    }
    public boolean check_bank(double amount,String user_n,String pass,String card_num){
        if(Bank.updateBalance(generate_api_key(user_n,pass,card_num),amount)){
            return true;
        }
        return false;
    }
}
