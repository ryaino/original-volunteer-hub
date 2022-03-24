package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.List;
import java.util.Optional;

import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.AbstractFirestoreDocumentRepository;

/**
 * Performs generic service logic when dealing with documents
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public abstract class AbstractDocumentService<D extends AbstractFirestoreDocument, R extends AbstractFirestoreDocumentRepository<D>> {

    public AbstractFirestoreDocumentRepository<D> repository;

    public AbstractDocumentService(AbstractFirestoreDocumentRepository<D> repository) {
        this.repository = repository;
    }

    /**
     * Tells the repository to search for the document with matching id
     *
     * @param id
     * @return POJO representing the document
     */
    public D getDocumentById(String id) {
        Optional<AbstractFirestoreDocument> documentOptional = repository.findById(id);
        return (D) documentOptional.get();
    }

    /**
     * gets all documents that have the matching value for the given field
     *
     * @param fieldName
     * @param fieldValue
     * @return List of all matching documents
     */
    public List<D> getDocumentsByFieldValue(String fieldName, Object fieldValue) {
        return repository.findAllByFieldValue(fieldName, fieldValue);
    }

    /**
     * updates specified field of a document
     *
     * @param documentId
     * @param fieldName
     * @param fieldValue
     * @return whether or not the update was successfull
     */
    public boolean updateDocumentField(String documentId, String fieldName, Object fieldValue) {
        return repository.updateDocumentField(documentId, fieldName, fieldValue);
    }

}
