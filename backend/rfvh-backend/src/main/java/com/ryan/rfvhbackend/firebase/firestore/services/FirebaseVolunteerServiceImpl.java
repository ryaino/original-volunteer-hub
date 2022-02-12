package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.ryan.rfvhbackend.volunteers.Volunteer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for {@link FirebaseVolunteerService}
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Service
public class FirebaseVolunteerServiceImpl implements FirebaseVolunteerService {

    @Autowired
    public FirebaseVolunteerServiceImpl() {

    }

    @Override
    public void addVolunteer(Volunteer volunteer) {
        ApiFuture<DocumentReference> addedDocRef = FirestoreClient.getFirestore().collection("volunteers")
                .add(volunteer);
        try {
            System.out.println("Added document with ID: " + addedDocRef.get().getId());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public List<Volunteer> findAll() {
        List<Volunteer> allVolunteers = new ArrayList<Volunteer>();

        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection("volunteers").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents;

        try {
            documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                allVolunteers.add(document.toObject(Volunteer.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------");

        return allVolunteers;

    }

}
