package UserPackage;

public class Account {
    private String mobileNumber;
    private String password;
    private String name;
    private String email;
    private double balance;
    private AccountType type;

    // default constructor
    public Account() {
        this("", "", "", "");
    }

    // parameterized constructor
    public Account(String mobileNumber, String password, String name, String email) {
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.name = name;
        setEmail(email);
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
        // Implement secure password handling (e.g., hashing and salting)
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        // Implement more robust email validation
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double initialBalance) {
        this.balance = initialBalance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
