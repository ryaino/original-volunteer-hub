package com.ryan.rfvhbackend.firebase.authentication.services;

import com.google.firebase.auth.UserRecord;
import com.ryan.rfvhbackend.firebase.authentication.AuthUser;
import com.ryan.rfvhbackend.firebase.authentication.repositories.UserAuthRepository;
import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.UserDocumentRepository;

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

    private UserDocumentRepository userDocumentRepository;

    UserAuthServiceimpl(UserAuthRepository userAuthRepository, UserDocumentRepository userDocumentRepository) {
        this.userAuthRepository = userAuthRepository;
        this.userDocumentRepository = userDocumentRepository;

    }

    @Override
    public void createNewUser(AuthUser user) {
        logger.debug("creating new auth user");
        UserRecord userRecord = userAuthRepository.createUser(user);
        UserDocument userDocument = new UserDocument(userRecord.getDisplayName(), userRecord.getEmail(),
                userRecord.getUid());
        userDocumentRepository.save(userDocument);

    }

}
