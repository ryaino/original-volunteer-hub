package com.ryan.rfvhbackend.firebase.firestore.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles all common functionality for accessing firestore. Whenever a
 * collection needs accessing then a repository dedicated to that collection
 * must be created that extends this class.
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public abstract class AbstractFirestoreDocumentRepository<T extends AbstractFirestoreDocument> {

    private final Logger logger;

    protected AbstractFirestoreDocumentRepository() {
        this.logger = LoggerFactory.getLogger(classType());
    }

    public long count() {
        throw new NotImplementedException();
    }

    public void delete(AbstractFirestoreDocument entity) {
        throw new NotImplementedException(entity.toString());
    }

    public void deleteAll() {
        throw new NotImplementedException();
    }

    public void deleteAllById(Iterable<? extends String> ids) {
        throw new NotImplementedException();
    }

    public void deleteById(String id) {
        throw new NotImplementedException();

    }

    public boolean existsById(String id) {
        throw new NotImplementedException();
    }

    public Iterable<AbstractFirestoreDocument> findAll() {
        throw new NotImplementedException();
    }

    public Iterable<T> findAllById(Iterable<String> ids) {
        throw new NotImplementedException();
    }

    public Optional<T> findById(String id) {
        Optional<T> result = Optional.empty();
        DocumentReference docRef = FirestoreClient.getFirestore().collection(collectionName()).document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();

        try {
            DocumentSnapshot document = future.get();
            T targetDocument = null;

            if (document.exists()) {
                targetDocument = document.toObject(classType());
                result = Optional.of(targetDocument);
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Unable to find object with id: [{}]", id);
            Thread.currentThread().interrupt();
        }
        return result;
    }

    public T save(T entity) {
        FirestoreClient.getFirestore().collection(collectionName())
                .document(entity.id()).set(entity);
        return null;
    }

    public <S extends AbstractFirestoreDocument> Iterable<S> saveAll(Iterable<T> entities) {
        throw new NotImplementedException(entities.toString());
    }

    /**
     *
     * @param <S>
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public List<T> findAllByFieldValue(String fieldName, Object fieldValue) {
        List<T> results = new ArrayList<>();
        ApiFuture<QuerySnapshot> future = FirestoreClient.getFirestore().collection(collectionName())
                .whereEqualTo(fieldName, fieldValue).get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                results.add(document.toObject(classType()));
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Unable to find object with field: [{}] and value: [{}]", fieldName, fieldValue);
            Thread.currentThread().interrupt();
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
                docRef.update(fieldName, fieldValue);
                return true;
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Unable to find object with if: [{}] field: [{}] and value: [{}]", documentId, fieldName,
                    fieldValue);
            Thread.currentThread().interrupt();
        }
        return false;
    }

    public abstract String collectionName();

    public abstract Class<T> classType();

    public void deleteAll(Iterable<? extends AbstractFirestoreDocument> entities) {
        throw new NotImplementedException();
    }

}
