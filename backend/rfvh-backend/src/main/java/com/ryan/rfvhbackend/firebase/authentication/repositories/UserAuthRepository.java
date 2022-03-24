package com.ryan.rfvhbackend.firebase.authentication.repositories;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.ryan.rfvhbackend.firebase.authentication.AuthUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthRepository {

    Logger logger = LoggerFactory.getLogger(UserAuthRepository.class);

    public UserRecord createUser(AuthUser user) {
        CreateRequest request = new CreateRequest()
                .setEmail(user.getEmail())
                .setEmailVerified(false)
                .setPassword(user.getPassword())
                .setDisplayName(user.getDisplayName())
                .setPhotoUrl(user.getPhotoUrl())
                .setDisabled(false);

        try {
            return FirebaseAuth.getInstance().createUser(request);
        } catch (FirebaseAuthException e) {
            logger.error("Unable to create new user with email: {}", user.getEmail());
            return null;

        }
    }

}
