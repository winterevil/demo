package vn.eiu.edu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.eiu.edu.demo.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User searchUserByUsernameIgnoreCase(String username);
}
