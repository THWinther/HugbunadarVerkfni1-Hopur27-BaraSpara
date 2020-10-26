package is.hi.hbv501g.BaraSpara.User;

public class user {


    private String userIdentity;
    private String userPasscode;
    private UserRegister userRegister;


    public user(String Id, String key){
        userIdentity = Id;
        userPasscode = key;
    }

    public static String UserId(user User) {
        return User.userIdentity;
    }

    public static String getUserPasscode(user User) {
        return User.userPasscode;
    }

    private boolean UserAuthenticate(String userPasscode, UserRegister userRegister){
        //authenticate passcode, if incorrect return false
        return true;
    }
}
