package com.ryan.rfvhbackend.firebase.firestore.repositories;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;

import org.springframework.stereotype.Repository;

/**
 * CRUD repository that deals with {@link UserDocument}
 */
@Repository
public class UserDocumentRepository extends AbstractFirestoreDocumentRepository<UserDocument> {

    public UserDocumentRepository() {
        super();
    }

    @Override
    public String collectionName() {
        return UserDocument.COLLECTION_NAME;
    }

    @Override
    public Class<UserDocument> classType() {
        return UserDocument.class;
    }

}
