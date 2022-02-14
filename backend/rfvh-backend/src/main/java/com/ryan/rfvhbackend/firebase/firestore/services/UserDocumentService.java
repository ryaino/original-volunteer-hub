package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.Optional;

import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.UserDocumentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserDocumentService}
 */
@Service
public class UserDocumentService extends AbstractDocumentService<UserDocument, UserDocumentRepository> {

    Logger logger = LoggerFactory.getLogger(UserDocumentService.class);

    @Autowired
    public UserDocumentService(UserDocumentRepository userDocumentRepository) {
        super(userDocumentRepository);

    }

}
