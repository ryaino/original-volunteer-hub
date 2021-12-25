package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.List;

import com.ryan.rfvhbackend.volunteers.Volunteer;

public interface FirebaseVolunteerService {

    void addVolunteer(Volunteer volunteer);

    List<Volunteer> findAll();
}
