package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.Optional;

import com.ryan.rfvhbackend.firebase.firestore.documents.FirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.UserDocumentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserDocumentService}
 */
@Service
public class UserDocumentServiceImpl implements UserDocumentService {

    Logger logger = LoggerFactory.getLogger(UserDocumentServiceImpl.class);
    private UserDocumentRepository userDocumentRepository;

    public UserDocumentServiceImpl(UserDocumentRepository userDocumentRepository) {
        this.userDocumentRepository = userDocumentRepository;

    }

    @Override
    public UserDocument getUserDocument(String userId) {
        Optional<FirestoreDocument> documentOptional = userDocumentRepository.findById(userId);
        return (UserDocument) documentOptional.get();
    }

}
