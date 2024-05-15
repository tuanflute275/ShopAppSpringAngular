package vn.tuanflutte.services.user;

import vn.tuanflutte.dtos.request.JwtRequest;
import vn.tuanflutte.dtos.response.JwtResponse;
import vn.tuanflutte.entities.Product;
import vn.tuanflutte.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public void initRoleAndUser();
    public User registerNewUser(User user);
    public String getEncodedPassword(String password);
    public List<User> findByUserName(String key);
    public User findOneUser(String key);
    public List<User> findAll();
    public Optional<User> findById(String userId);
    public User save(User user);
    public void deleteByUsername(User user);
    public void resetPassword(String username, String newPassword);
    public void blockOrEnable(String username, int active);
    public Boolean existsByEmail(String email);
    public Optional<User> findByEmail(String email);
    public JwtResponse login(JwtRequest jwtRequest) throws Exception;
    public void enableUser(String userName);
    public void updateCount(String username);
    public Integer getUserCount(String username);
}
