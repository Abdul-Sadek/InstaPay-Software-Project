package UserPackage;

public class Admin extends User{

    public final Admin_collection functionalities = new Admin_collection();


    // parameterized constructor
    public Admin(String name, String username, String password) {
        super(name, username, password);
        this.x = new Collection();
    }

}
