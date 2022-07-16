package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.List;

import com.ryan.rfvhbackend.volunteers.Volunteer;

/**
 * CRUD Repository for interacting with the volunteers collection
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public interface FirebaseVolunteerService {

    /**
     * Adds a single volunteer document to the collection
     *
     * @param volunteer
     */
    void addVolunteer(Volunteer volunteer);

    /**
     * Fetches all documents in the collection
     *
     * @return all documents
     */
    List<Volunteer> findAll();
}
