package com.ryan.rfvhbackend.firebase.firestore.documents;

import java.util.UUID;

public class UserDocument extends FirestoreDocument {

    public static String COLLECTION_NAME = "users";

    private String id;
    private String name;
    private String email;

    public UserDocument() {
    }

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDocument(String name, String email, String id) {
        this.setName(name);
        this.setEmail(email);
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String collectionName() {
        return "users";
    }

}
