package com.ryan.rfvhbackend.firebase.firestore.services;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.UserDocumentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Service
public class UserDocumentService extends AbstractDocumentService<UserDocument, UserDocumentRepository> {

    Logger logger = LoggerFactory.getLogger(UserDocumentService.class);

    @Autowired
    public UserDocumentService(UserDocumentRepository userDocumentRepository) {
        super(userDocumentRepository);
    }

}
