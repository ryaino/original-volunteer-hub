package com.ryan.rfvhbackend.firebase.firestore.services;

import java.util.Optional;

import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.AbstractFirestoreDocumentRepository;

public abstract class AbstractDocumentService<D extends AbstractFirestoreDocument, R extends AbstractFirestoreDocumentRepository<D>> {

    public AbstractFirestoreDocumentRepository<D> repository;

    public AbstractDocumentService(AbstractFirestoreDocumentRepository<D> repository) {
        this.repository = repository;
    }

    public D getDocumentById(String id) {
        Optional<AbstractFirestoreDocument> documentOptional = repository.findById(id);
        return (D) documentOptional.get();
    }

}
