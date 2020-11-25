package is.hi.hbv501g.BaraSpara.Repositories;


import is.hi.hbv501g.BaraSpara.Entities.User;

import java.util.List;

public interface UserRepo {
    User save(User user);
    void delete (User user);
    User findByuserIdentity(String userIdentity);
    List<User> findAll();

}
