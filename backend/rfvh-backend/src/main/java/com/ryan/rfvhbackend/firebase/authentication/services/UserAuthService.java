package com.ryan.rfvhbackend.firebase.authentication.services;

import com.ryan.rfvhbackend.firebase.authentication.AuthUser;

/**
 * Handles logic when dealing with the authentication instance of a user
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public interface UserAuthService {

    /**
     * Create a new authentication user that is able to log into the app.
     * A new user document should also be created in the users collection with a
     * matching id.
     *
     * @param user
     */
    void createNewUser(AuthUser user);

}
