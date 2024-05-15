package vn.tuanflutte.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.tuanflutte.configuration.JwtRequestFilter;
import vn.tuanflutte.dtos.request.ChangePasswordForm;
import vn.tuanflutte.dtos.request.JwtRequest;
import vn.tuanflutte.dtos.request.ResetPassword;
import vn.tuanflutte.dtos.request.SendEmail;
import vn.tuanflutte.entities.User;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.repositories.UserRepository;
import vn.tuanflutte.sendEmail.ProvideSendEmail;
import vn.tuanflutte.services.uploadFile.IUploadFileService;
import vn.tuanflutte.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import vn.tuanflutte.utils.JwtUtil;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ProvideSendEmail provideSendEmail;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IUploadFileService uploadImage;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> getAllUser(@RequestParam(defaultValue = "") String key){
        List<User> list = null;
        if (key.equals("")){
            list = userService.findAll();
        }else {
            list = userService.findByUserName(key);
            if(list.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "No Data", "")
                );
            }
        }
        if(!list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query category successfully", list)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }
    }

    @GetMapping("/user/{userName}")
//    @PreAuthorize("hasRole('Admin') and hasRole('User')")
    ResponseEntity<ResponseObject> findById(@PathVariable String userName){
        Optional<User> foundCategory = Optional.of(userService.findById(userName).get());
        if(foundCategory.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query user successfully", foundCategory)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find user with id = "+userName, "")
            );
        }
    }

    @PostMapping({"/registerNewUser"})
    ResponseEntity<ResponseObject> registerNewUser(@RequestBody User user) {
        //check unique
        List<User> foundUser = userService.findByUserName(user.getUserName().trim());
        try {
            if(foundUser.size() > 0){
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("error", "username name already taken", "")
                );
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Insert data successfully", userService.registerNewUser(user))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", "")
            );
        }
    }

    @PostMapping({"/authenticate"})
    ResponseEntity<ResponseObject> login(@RequestBody JwtRequest jwtRequest){
        try {
            userService.enableUser(jwtRequest.getUserName());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Login thành công", userService.login(jwtRequest))
            );
        }catch (Exception e){
            userService.updateCount(jwtRequest.getUserName());
            Integer userCount = userService.getUserCount(jwtRequest.getUserName());
            if(userCount == 3){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new ResponseObject("failed", "Tài khoản bị khóa 10s", userCount)
                );
            }
            if(userCount == 4){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new ResponseObject("failed", "Tài khoản bị khóa 2 phút", userCount)
                );
            }
            if(userCount == 5){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new ResponseObject("failed", "Tài khoản bị khóa 3 phút", userCount)
                );
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("failed", "Login failed", userCount)
            );
        }
    }
    @PutMapping("/user/{userName}")
//    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable String userName){
        User updateUser = userService.findById(userName)
                .map(user -> {
                    user.setUserName(newUser.getUserName());
                    user.setUserEmail(newUser.getUserEmail());
                    user.setUserFullName(newUser.getUserFullName());
                    user.setUserAvatar(newUser.getUserAvatar());
                    user.setUserPassword(user.getUserPassword());
                    user.setUserPhoneNumber(newUser.getUserPhoneNumber());
                    user.setUserAddress(newUser.getUserAddress());
                    user.setUserGender(newUser.getUserGender());
                    user.setUserActive(newUser.getUserActive());
                    return userService.save(user);
                }).orElseGet(()->{
                    newUser.setUserName(userName);
                    return userService.save(newUser);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfuly", updateUser)
        );
    }

    @PostMapping({"/user/delete"})
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> deleteUser(@RequestBody User user){
        userService.deleteByUsername(user);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Delete data successfuly", "")
        );
    }

    @PutMapping({"/reset-password/{username}"})
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> resetPasswordByAdmin(@PathVariable String username){
        List<User> user = userService.findByUserName(username);
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "User not found", "")
            );
        }
        try {
            String newPassword = UUID.randomUUID().toString().substring(0,6);
            userService.resetPassword(username, newPassword);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Reset password successfully", newPassword)
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", e.getMessage(), "")
            );
        }
    }

    @PutMapping({"/block/{username}/{active}"})
    @PreAuthorize("hasRole('Admin')")
    ResponseEntity<ResponseObject> blockOrEnable(@PathVariable String username, @PathVariable int active){
        try {
            userService.blockOrEnable(username, active);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Block Account successfully", "")
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", e.getMessage(), "")
            );
        }
    }

    @PutMapping("/change/password")
    public ResponseEntity<ResponseObject> changePassword(HttpServletRequest request, @Valid @RequestBody ChangePasswordForm changePasswordForm){
        String userName = JwtRequestFilter.CURRENT_USER;
        try {
            User user =  userRepository.findUserByUserName(userName);
            boolean matches = passwordEncoder.matches(changePasswordForm.getCurrentPassword(), user.getUserPassword());
            if(changePasswordForm.getNewPassword() != null){
                if(matches){
                    user.setUserPassword(passwordEncoder.encode(changePasswordForm.getNewPassword()));
                    userService.save(user);
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(
                            new ResponseObject("failed", "Current password is incorrect", "")
                    );
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed", "Change Password sucesss", "")
            );
        } catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed", "Change Password Failed", e.getMessage())
            );
        }
    }

    @PostMapping("/send/email")
    public ResponseEntity<ResponseObject> sendEmail(@RequestBody SendEmail sendEmail){
        User user;
        if (userService.existsByEmail(sendEmail.getSendEmail())){
            user = userService.findByEmail(sendEmail.getSendEmail()).orElseThrow(()->new UsernameNotFoundException("Email Not Found with -> email"));
            String token = jwtUtil.createEmailToken(user.getUserName());
            String linkReset = "http://localhost:4200/reset-password/"+token;
            provideSendEmail.sendSimpleMessage(sendEmail.getSendEmail(),"Thay doi mat khau",linkReset);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Thành công, vui lòng kiểm tra email", linkReset)
            );
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed", "Không tồn tại email !", "")
            );
        }
    }

    @PostMapping("/reset/password")
    public ResponseEntity<ResponseObject> resetPasswordWithEmail(HttpServletRequest request, @Valid @RequestBody ResetPassword resetPassword){
        try {
            String jwt = resetPassword.token;
            String username = jwtUtil.getUerNameFromToken(jwt);
            User user;
            user = userService.findOneUser(username);
            user.setUserPassword(resetPassword.getNewpassword());
            user.setUserPassword(passwordEncoder.encode(resetPassword.getNewpassword()));
            userService.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Reset Password successfully", "")
            );
        } catch (UsernameNotFoundException exception){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("failed", exception.getMessage(), "")
            );
        }
    }

    @PostMapping("/upload-image/{folder}")
    public ResponseEntity<ResponseObject> updateImage(@PathVariable String folder,
                                                      @ModelAttribute MultipartFile image) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Upload file successfully", uploadImage.uploadImage(folder,image))
        );
    }


    //login by google
//    @GetMapping("/login/google")
//    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken){
//        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
//    }

}
