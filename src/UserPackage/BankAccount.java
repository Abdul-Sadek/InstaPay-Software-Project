package UserPackage;

public class BankAccount extends Account{
    private String card_num;
    private String user_name;
    private String bank_bass;


    public BankAccount(String mobileNumber, String email, String password, AccountType type , String cardnum, String username, String bankbass ) {
        super(mobileNumber, email, password, type);
        this.card_num=cardnum;
        this.user_name=username;
        this.bank_bass=bankbass;
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
}
