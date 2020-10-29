package is.hi.hbv501g.BaraSpara;


import is.hi.hbv501g.BaraSpara.User.user;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<user> allUsers = new ArrayList<>();


    public user signUp(String email, String username, String password){
        if (doesexist(email)) {
            System.out.print("Email is already in use");
            return null;
        }
        user entry = new user(username,password,email);
        allUsers.add(entry);
        return entry;
    }

    private boolean doesexist(String entry){
        for (int i= 0; i < allUsers.size(); i++){
            user a = allUsers.get(i);
            if(a.getEmail().equals(entry)){
                return true;
            }
        }
        return false;
    }
}
