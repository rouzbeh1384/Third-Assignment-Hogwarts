import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account implements AccountManagement{
    private String username;
    // TODO: Passwords should hashed
    private String password;
    private UUID accountID;

    //Constructor
    public Account() {accountID=UUID.randomUUID();}


    /**
     * check the password is same or not
     * @param enteredPassword
     * @return
     */
    @Override
    public boolean validatePassword(String enteredPassword) {
        if (this.password==enteredPassword)
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
}
