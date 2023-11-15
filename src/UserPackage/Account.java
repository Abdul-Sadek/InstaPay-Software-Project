package UserPackage;

public class Account {
    protected String mobileNumber;

    protected String password;
    protected String name;
    protected String email;
    protected double balance;

    protected AccountType type;

    // default constructor
    public Account() {
        mobileNumber = "";
        password = "";
        name = "";
        email = "";
        balance = 0;
    }
    // parameterized constructor
    public Account(String mobileNumber, String password, String name, String email) {
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.balance = 0;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        if(email.contains("@") && email.contains(".")) {
            this.email = email;
        }
    }
    // determine if bank or wallet or admin or any other type
    public double getBalance() {
        return balance;
    }
    public void setBalance(double v) {
        this.balance = v;
    }
    public AccountType getType() {
        return type;
    }
    public void setType(AccountType type) {
        this.type = type;
    }
}
