package is.hi.hbv501g.BaraSpara.User;

import java.util.List;

public class user {


    private String userIdentity;
    private String userPasscode;
    private String email;
    private List<user> userRegister;


    public user(String Id, String key, String mail){
        userIdentity = Id;
        userPasscode = key;
        email = mail;
    }

    public static String UserId(user User) {
        return User.userIdentity;
    }

    public static String getUserPasscode(user User) {
        return User.userPasscode;
    }

    public String getEmail(){
        return email;
    }


    private boolean UserAuthenticate(String userPasscode, List<user> userRegister){
        //authenticate passcode, if incorrect return false
        return true;
    }
}
