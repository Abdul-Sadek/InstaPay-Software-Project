package UserPackage;

public abstract class Account {
    protected String mobileNumber;
    protected String password;
    protected String name;
    protected String email;
     protected AccountType type;
    protected double balance;

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
    public AccountType getType() {
        return type;
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
    public void setType(AccountType type) {
        this.type = type;
    }
    public abstract double getBalance(User user);
}
