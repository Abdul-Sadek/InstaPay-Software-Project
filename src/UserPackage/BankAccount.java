package UserPackage;

public class BankAccount extends Account {
    private String card_num;
    private String user_name;
    private String bank_bass;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    // default constructor
    public BankAccount() {
        super();
        card_num = "";
        user_name = "";
        bank_bass = "";
    }

    // parameterized constructor
    public BankAccount(String mobileNumber, String password, String name, String email, String card_num, String user_name, String bank_bass) {
        super(mobileNumber, password, name, email);
        this.card_num = card_num;
        this.user_name = user_name;
        this.bank_bass = bank_bass;
    }

    public String getCardNum() {
        return card_num;
    }

    public String getUserName() {
        return user_name;
    }

    public String getBankBass() {
        return bank_bass;
    }

    // Setter methods
    public void setCardNum(String cardnum) {
        this.card_num = cardnum;
    }

    public void setUserName(String username) {
        this.user_name = username;
    }

    public void setBankBass(String bankbass) {
        this.bank_bass = bankbass;
    }

    public void print() {
        System.out.println("Bank Account Information:");
        System.out.println("Name: " + getName());
        System.out.println("Mobile Number: " + getMobileNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Card Number: " + card_num);
        System.out.println("Username: " + user_name);
        System.out.println("Bank Name: " + bank_bass);
        System.out.println("Balance: " + getBalance());
        System.out.println("-------------------------------");
    }
}
