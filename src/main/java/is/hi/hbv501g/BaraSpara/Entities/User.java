package is.hi.hbv501g.BaraSpara.Entities;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {


    public String userIdentity;
    public String userPasscode;
    public String email;
    private List<User> userRegister = new ArrayList<>();


    public User(String Id, String key, String mail){
        userIdentity = Id;
        userPasscode = key;
        email = mail;
    }

    public static String UserId(User User) {
        return User.userIdentity;
    }

    public static String getUserPasscode(User User) {
        return User.userPasscode;
    }

    public String getEmail(){
        return email;
    }

    public String toString() {
        return userIdentity;
    }

    public List<User> getUserRegistry(){
        return userRegister;
    }
}

