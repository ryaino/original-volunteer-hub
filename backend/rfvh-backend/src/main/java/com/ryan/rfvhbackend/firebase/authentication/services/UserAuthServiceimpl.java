package com.ryan.rfvhbackend.firebase.authentication.services;

import com.ryan.rfvhbackend.firebase.authentication.AuthUser;
import com.ryan.rfvhbackend.firebase.authentication.repositories.UserAuthRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserAuthService}
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Service
public class UserAuthServiceimpl implements UserAuthService {

    Logger logger = LoggerFactory.getLogger(UserAuthServiceimpl.class);

    private UserAuthRepository userAuthRepository;

    UserAuthServiceimpl(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;

    }

    @Override
    public void createNewUser(AuthUser user) {
        logger.debug("creating new auth user");
        userAuthRepository.createUser(user);

    }

}
