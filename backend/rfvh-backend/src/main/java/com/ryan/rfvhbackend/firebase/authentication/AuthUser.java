package com.ryan.rfvhbackend.firebase.authentication;

/**
 * Represents all fields needed to create a new user. This created from what is
 * sent from the frontend
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public class AuthUser {

    private String email;
    private String password;
    private String displayName;
    private String photoUrl;

    public AuthUser(String email, String password, String displayName, String photoUrl) {
        this.email = email;
        this.password = password;
        this.displayName = displayName;
        this.photoUrl = photoUrl;

    }

    public AuthUser() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    @Override
    public String toString() {
        return "User [displayName=" + displayName + ", email=" + email + ", password=" + password + ", photoUrl="
                + photoUrl + "]";
    }

}
