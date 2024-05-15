package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tuanflutte.entities.Product;
import vn.tuanflutte.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public List<User> findByUserName(String key);
    List<User> removeByUserName(String userName);
    @Query("select u from User u where u.userName = ?1")
    User findUserByUserName(String key);
    Boolean existsByUserEmail(String email);
    Optional<User> findByUserEmail(String email);
}
