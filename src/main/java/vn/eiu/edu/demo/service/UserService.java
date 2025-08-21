package vn.eiu.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.demo.model.User;
import vn.eiu.edu.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void saveUser(User user){
        userRepo.save(user);
    }

    public User findByUsername(String username){
        return userRepo.searchUserByUsernameIgnoreCase(username);
    }
}
