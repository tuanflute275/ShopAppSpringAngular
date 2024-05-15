package vn.tuanflutte.dtos.response;

import vn.tuanflutte.entities.User;

public class JwtResponse {

    private User user;
    private String jwtToken;
    private String message;

    public JwtResponse(String message, User user, String jwtToken) {
        this.message = message;
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
