package vn.tuanflutte.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.tuanflutte.dtos.request.JwtRequest;
import vn.tuanflutte.dtos.response.JwtResponse;
import vn.tuanflutte.repositories.RoleRepository;
import vn.tuanflutte.repositories.UserRepository;
import vn.tuanflutte.entities.Role;
import vn.tuanflutte.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepo.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("111111"));
        adminUser.setUserEmail("admin@gmail.com");
        adminUser.setUserFullName("admin");
        adminUser.setUserPhoneNumber("0982467073");
        adminUser.setUserAddress("Ba Vì - Hà Nội");
        adminUser.setUserGender(0);
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);

        User user = new User();
        user.setUserName("user");
        user.setUserPassword(getEncodedPassword("111111"));
        user.setUserEmail("user@gmail.com");
        user.setUserFullName("user");
        user.setUserPhoneNumber("0386564543");
        user.setUserAddress("Ba Vì - Hà Nội");
        user.setUserGender(0);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepo.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleRepo.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepo.save(user);
    }

    @Override
    public JwtResponse login(JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public List<User> findByUserName(String key) {
        return userRepo.findByUserName(key);
    }

    @Override
    public User findOneUser(String key) {
        return userRepo.findUserByUserName(key);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(String userId) {
        return userRepo.findById(userId);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteByUsername(User user) {
        userRepo.delete(user);
    }

    @Override
    @Transactional
    public void resetPassword(String username, String newPassword) {
        User user = userRepo.findUserByUserName(username);
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setUserPassword(encodedPassword);
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void blockOrEnable(String username, int active) {
        User user = userRepo.findUserByUserName(username);
        user.setUserActive(active);
        userRepo.save(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepo.existsByUserEmail(email);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByUserEmail(email);
    }

    @Override
    @Transactional
    public void enableUser(String userName){
        System.out.println(userName);
        LocalTime now = LocalTime.now();
        int hour = now.getHour() * 60 * 60;
        int minute = now.getMinute() * 60;
        int second = now.getSecond();
        int currentTime  = hour+minute+second;
        User user = userRepo.findUserByUserName(userName);
        if(currentTime >= user.getUserUnlockTime()){
            user.setUserActive(0);
            userRepo.save(user);
        }
    }

    @Transactional
    @Override
    public void updateCount(String username) {
        System.out.println(java.time.LocalTime.now());
        User user = userRepo.findUserByUserName(username);
        user.setUserCount((user.getUserCount())+1);
        LocalTime now = LocalTime.now();
        int hour = now.getHour() * 60 * 60;
        int minute = now.getMinute() * 60;
        int second = now.getSecond();
        int currentTime  = hour+minute+second;

        if (user.getUserCount() == 3){
            user.setUserCurrentTime(currentTime);
            user.setUserUnlockTime(currentTime + 10);
            user.setUserActive(1);
            userRepo.save(user);
        }
        if (user.getUserCount() == 4){
            user.setUserCurrentTime(currentTime);
            user.setUserUnlockTime(currentTime + 120);
            user.setUserActive(1);
            userRepo.save(user);
        }
        if (user.getUserCount() == 5){
            user.setUserCurrentTime(currentTime);
            user.setUserUnlockTime(currentTime+180);
            user.setUserActive(1);
            userRepo.save(user);
        }

        System.out.println("Current time : "+java.time.LocalTime.now());
        System.out.println(currentTime);
        userRepo.save(user);
    }

    @Override
    public Integer getUserCount(String username) {
        User user = userRepo.findUserByUserName(username);
        return user.getUserCount();
    }

    public void setCountDefault(String username) {
        User user = userRepo.findUserByUserName(username);
        user.setUserCount(0);
        userRepo.save(user);
    }
}
