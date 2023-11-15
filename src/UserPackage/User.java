package UserPackage;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    public Collection x;
    private String type;
    private int user_id;
    private String[] permissions;
    private Account account;


    // default constructor
    public User() {
        name = "";
        x = new Collection();
        type = "";
        user_id = 0;
        permissions = new String[0];
        account = new Account();
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.x = new Collection();
        this.type = "Client";
        this.user_id = 0;
        this.permissions = new String[0];
        this.account = new Account(username, password, name, "");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getCollections() {
        return x;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    //get account
    public Account getAccount() {
        return account;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

}
