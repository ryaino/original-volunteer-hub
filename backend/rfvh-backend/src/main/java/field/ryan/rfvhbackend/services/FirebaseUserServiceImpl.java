package field.ryan.rfvhbackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import field.ryan.rfvhbackend.repositories.User;

@Service
public class FirebaseUserServiceImpl implements FirebaseUserService {

    private final Firestore dbFirestore;

    @Autowired
    public FirebaseUserServiceImpl() {
        dbFirestore = FirestoreClient.getFirestore();

    }

    @Override
    public void addUser(User user) throws InterruptedException, ExecutionException {
        ApiFuture<DocumentReference> addedDocRef = dbFirestore.collection("users").add(user);
        System.out.println("Added document with ID: " + addedDocRef.get().getId());

    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<User>();

        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("users").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                allUsers.add(document.toObject(User.class));
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return allUsers;

    }

}
