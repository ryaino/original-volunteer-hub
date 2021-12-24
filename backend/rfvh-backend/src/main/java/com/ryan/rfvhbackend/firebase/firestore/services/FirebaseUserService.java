package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.List;

import com.ryan.rfvhbackend.user.models.User;

public interface FirebaseUserService {

    void addUser(User user);

    List<User> findAll();
}
