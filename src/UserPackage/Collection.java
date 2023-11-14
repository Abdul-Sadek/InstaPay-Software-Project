package UserPackage;

public abstract class Collection {


    public void view_profile(User x){
        System.out.println(
                "Username : "+x.getName()+"\n"+
                "User ID : "+x.getUserId()+"\n"+
                "User type : "+x.getType()+'\n'
        );

        for (Account account : x.getAccounts()) {
            System.out.println("Account Type: " + account.getType());
            System.out.println("Mobile Number: " + account.getMobileNumber());
            System.out.println("Email: " + account.getEmail());
        }
        for(String i : x.getPermissions()){
            System.out.println(i);
        }
    }
}
