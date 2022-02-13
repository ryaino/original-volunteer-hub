package com.ryan.rfvhbackend.firebase.firestore.repositories;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;

import org.springframework.stereotype.Repository;

@Repository
public class UserDocumentRepository extends FirestoreDocumentRepository<UserDocument> {

    @Override
    public String collectionName() {
        return UserDocument.COLLECTION_NAME;
    }

    @Override
    public Class<UserDocument> classType() {
        return UserDocument.class;
    }

}
