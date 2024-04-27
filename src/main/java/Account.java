import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account implements AccountManagement{
    private String username;
    // TODO: Passwords should hashed
    private String password;
    private UUID accountID;

    //Constructor
    public Account(String username,String password) {
        accountID=UUID.randomUUID();
        this.username=username;
        this.password=password;
    }


    /**
     * check the password is same or not
     * @param enteredPassword
     * @return
     */
    @Override
    public boolean validatePassword(String enteredPassword) {
        if (this.password.equals(enteredPassword))
            return true ;
        return false;
    }
    @Override
    public void changeUsername(String newUsername) {
        this.username=newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password=newPassword;

    }
    public String getUsername()
    {
        return username;
    }

}
