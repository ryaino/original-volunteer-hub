package com.ryan.rfvhbackend.firebase.firestore.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;

import org.springframework.data.repository.CrudRepository;

public abstract class AbstractFirestoreDocumentRepository<T extends AbstractFirestoreDocument>
        implements CrudRepository<AbstractFirestoreDocument, String> {

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(AbstractFirestoreDocument entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends AbstractFirestoreDocument> entities) {
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
    public Iterable<AbstractFirestoreDocument> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<AbstractFirestoreDocument> findAllById(Iterable<String> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<AbstractFirestoreDocument> findById(String id) {
        Optional<AbstractFirestoreDocument> result = Optional.empty();
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
    public <S extends AbstractFirestoreDocument> S save(S entity) {
        ApiFuture<WriteResult> addedDocRef = FirestoreClient.getFirestore().collection(collectionName())
                .document(entity.id().toString()).set(entity);
        return null;
    }

    @Override
    public <S extends AbstractFirestoreDocument> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     *
     * @param <S>
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public <S extends AbstractFirestoreDocument> List<S> findAllByFieldValue(String fieldName, Object fieldValue) {
        List<S> results = new ArrayList<S>();
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection(collectionName())
                .whereEqualTo(fieldName, fieldValue).get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                results.add((S) document.toObject(classType()));
            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Update a document
     *
     * @param documentId
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public boolean updateDocumentField(String documentId, String fieldName, Object fieldValue) {
        DocumentReference docRef = FirestoreClient.getFirestore().collection(collectionName()).document(documentId);
        try {
            if (docRef.get().get().exists()) {
                ApiFuture<WriteResult> future = docRef.update(fieldName, fieldValue);
                return true;
            }
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public abstract String collectionName();

    public abstract Class<T> classType();

}
