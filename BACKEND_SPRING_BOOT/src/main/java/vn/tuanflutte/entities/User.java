package vn.tuanflutte.entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "UserName")
    private String userName;
    @Column(name = "UserFullName")
    private String userFullName;
    @Column(name = "UserAvatar")
    private String userAvatar;
    @Column(name = "UserEmail")
    private String userEmail;
    @Column(name = "UserPassword")
    private String userPassword;
    @Column(name = "UserPhoneNumber")
    private String userPhoneNumber;
    @Column(name = "UserAddress")
    private String userAddress;
    @Column(name = "UserGender")
    private int userGender;
    @Column(name = "UserActive")
    private int userActive;
    @Column(name = "UserCount")
    private int userCount;
    @Column(name = "UserCurrentTime")
    private int userCurrentTime;
    @Column(name = "UserUnlockTime")
    private int userUnlockTime;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

    public User() {
    }

    public User(String userName, String userFullName, String userEmail, String userPassword, String userPhoneNumber, String userAddress) {
        this.userName = userName;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public int getUserActive() {
        return userActive;
    }

    public void setUserActive(int userActive) {
        this.userActive = userActive;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getUserCurrentTime() {
        return userCurrentTime;
    }

    public void setUserCurrentTime(int userCurrentTime) {
        this.userCurrentTime = userCurrentTime;
    }

    public int getUserUnlockTime() {
        return userUnlockTime;
    }

    public void setUserUnlockTime(int userUnlockTime) {
        this.userUnlockTime = userUnlockTime;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
