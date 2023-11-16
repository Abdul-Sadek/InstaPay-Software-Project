package UserPackage;
public class Client extends User {
    private final String address;
    private final String phoneNumber;
    private final String email;
    protected final BankAccount bankAccount;
    protected final WalletAccount walletAccount;

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
    public final Client_collection functionalities = new Client_collection();
}
