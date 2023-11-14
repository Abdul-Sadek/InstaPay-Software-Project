package UserPackage;

public class User {
    private String name;
    public Collection x;
    private String type;
    private int user_id;
    private String[] permissions;
    private Account[] accounts;



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
    public void Add_Acc(Account acc){
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = acc;
                break;
            }
        }
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }
    public Account[] getAccounts() {
        return accounts;
    }

}