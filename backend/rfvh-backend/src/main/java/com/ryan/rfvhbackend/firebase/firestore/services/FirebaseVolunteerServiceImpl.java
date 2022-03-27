package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.ryan.rfvhbackend.volunteers.Volunteer;

import org.springframework.stereotype.Service;

/**
 * Implementation of {@link FirebaseVolunteerService}
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Service
public class FirebaseVolunteerServiceImpl implements FirebaseVolunteerService {

    @Override
    public void addVolunteer(Volunteer volunteer) {
        FirestoreClient.getFirestore().collection("volunteers")
                .add(volunteer);
    }

    @Override
    public List<Volunteer> findAll() {
        List<Volunteer> allVolunteers = new ArrayList<>();

        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection("volunteers").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents;

        try {
            documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                allVolunteers.add(document.toObject(Volunteer.class));
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        return allVolunteers;

    }

}
