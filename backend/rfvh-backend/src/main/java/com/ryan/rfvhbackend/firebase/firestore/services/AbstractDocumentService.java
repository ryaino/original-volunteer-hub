package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.List;
import java.util.Optional;

import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.AbstractFirestoreDocumentRepository;

/**
 * Performs generic service logic when dealing with documents
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
     * @return
     */
    public D getDocumentById(String id) {
        Optional<AbstractFirestoreDocument> documentOptional = repository.findById(id);
        return (D) documentOptional.get();
    }

    public List<D> getDocumentsByFieldValue(String fieldName, Object fieldValue) {
        return repository.findAllByFieldValue(fieldName, fieldValue);
    }

}
