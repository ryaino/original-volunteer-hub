package com.ryan.rfvhbackend.firebase.firestore.documents;

/**
 * Superclass for every class that represents a document in the database
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public abstract class AbstractFirestoreDocument {

    /**
     * Gets the id associated with the current document
     *
     * @return
     */
    public abstract String id();
}
