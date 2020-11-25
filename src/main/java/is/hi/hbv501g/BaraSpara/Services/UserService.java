package is.hi.hbv501g.BaraSpara.Services;

import is.hi.hbv501g.BaraSpara.Entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void delete (User user);
    User findByuserIdentity(String userIdentity);
    User login(User user);
    List<User> findAll();
}
