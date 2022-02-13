package com.ryan.rfvhbackend.firebase.firestore.documents;

/**
 * Superclass for every class that represents a document in the database
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public abstract class FirestoreDocument {

    final String collectionPath;

    FirestoreDocument(String collectionPath) {
        this.collectionPath = collectionPath;
    }

}
