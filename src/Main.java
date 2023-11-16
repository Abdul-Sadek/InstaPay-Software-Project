import System.*;



public class Main {
    public static void main(String[] args) {
        BankDatabase bankDatabase = new BankDatabase();
        API_System api = new API_System(bankDatabase);
        DataBase db = new DataBase();
        Instapay_system instapay_system = new Instapay_system(api, db);
        instapay_system.run();
    }
}