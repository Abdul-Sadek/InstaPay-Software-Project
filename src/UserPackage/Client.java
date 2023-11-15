package UserPackage;
public class Client extends User {
    private String address;
    private String phoneNumber;
    private String email;
    protected BankAccount bankAccount;
    protected WalletAccount walletAccount;

    // default constructor
    public Client() {
        super();
        address = "";
        phoneNumber = "";
        email = "";
        bankAccount = new BankAccount();
        walletAccount = new WalletAccount();
    }

    // parameterized constructor
    public Client(String mobileNumber, String password, String name, String email, String address, String phoneNumber) {
        super(mobileNumber, password, name);
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bankAccount = new BankAccount();
        this.walletAccount = new WalletAccount();
    }
    public Client_collection functionalities = new Client_collection();
}
