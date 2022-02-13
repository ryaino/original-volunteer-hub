package com.ryan.rfvhbackend.firebase.firestore.repositories;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.ryan.rfvhbackend.firebase.firestore.documents.FirestoreDocument;

import org.springframework.data.repository.CrudRepository;

public abstract class FirestoreDocumentRepository<T extends FirestoreDocument>
        implements CrudRepository<FirestoreDocument, String> {

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(FirestoreDocument entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends FirestoreDocument> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<FirestoreDocument> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<FirestoreDocument> findAllById(Iterable<String> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FirestoreDocument> findById(String id) {
        Optional<FirestoreDocument> result = Optional.empty();
        DocumentReference docRef = FirestoreClient.getFirestore().collection(collectionName()).document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();

        try {
            DocumentSnapshot document = future.get();
            T targetDocument = null;

            if (document.exists()) {
                targetDocument = (T) document.toObject(classType());
                result = Optional.of(targetDocument);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public <S extends FirestoreDocument> S save(S entity) {
        ApiFuture<WriteResult> addedDocRef = FirestoreClient.getFirestore().collection(entity.collectionName())
                .document(entity.id().toString()).set(entity);
        return null;
    }

    @Override
    public <S extends FirestoreDocument> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    public abstract String collectionName();

    public abstract Class<T> classType();

}
