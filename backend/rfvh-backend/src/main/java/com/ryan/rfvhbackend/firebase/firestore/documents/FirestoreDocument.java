package com.ryan.rfvhbackend.firebase.firestore.documents;

import java.util.UUID;

/**
 * Superclass for every class that represents a document in the database
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public abstract class FirestoreDocument {

    public abstract String collectionName();

    public abstract String id();
}
