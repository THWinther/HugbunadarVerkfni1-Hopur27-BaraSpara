package is.hi.hbv501g.BaraSpara.Services.Implementations;

import is.hi.hbv501g.BaraSpara.Entities.User;
import is.hi.hbv501g.BaraSpara.Repositories.UserRepo;
import is.hi.hbv501g.BaraSpara.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    UserRepo repo;

    public UserServiceImplementation (UserRepo repo){
        this.repo = repo;
    }


    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void delete(User user) {

        repo.delete(user);
    }

    @Override
    public User findByuserIdentity(String userIdentity) {
        return repo.findByuserIdentity(userIdentity);
    }

    @Override
    public User login(User user) {
        User isIn = findByuserIdentity(user.userIdentity);

        if (isIn != null){
            if (isIn.userPasscode.equals(user.userPasscode)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }
}
