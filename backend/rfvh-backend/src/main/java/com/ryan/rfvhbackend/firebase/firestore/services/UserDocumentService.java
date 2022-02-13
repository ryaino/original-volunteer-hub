package com.ryan.rfvhbackend.firebase.firestore.services;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;

/**
 * Service for dealing with and manipulating {@link UserDocument}
 */
public interface UserDocumentService {

    UserDocument getUserDocument(String userId);

}
