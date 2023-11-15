package UserPackage;

public class Admin extends User{

    private String name;
    private String username;
    private String password;

    public Admin_collection functionalities = new Admin_collection();

    //

    // parameterized constructor
    public Admin(String name, String username, String password) {
        super(name, username, password);
        this.name = name;
        this.username = username;
        this.password = password;
        this.x = new Collection();
    }

}
