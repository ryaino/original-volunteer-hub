package com.ryan.rfvhbackend.firebase.firestore.controllers;

import java.util.List;

import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.services.AbstractDocumentService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Parent controller that holds the logic for crud operations on documents
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@RestController
@RequestMapping("/api/document")
public abstract class AbstractDocumentController<D extends AbstractFirestoreDocument> {

    private AbstractDocumentService<D, ?> service;

    public AbstractDocumentController(AbstractDocumentService<D, ?> service) {
        this.service = service;
    }

    /**
     * find a single document using it's unique id
     *
     * @param id
     * @return
     */
    public D getDocumentById(String id) {
        return service.getDocumentById(id);
    }

    /**
     * find all documents that contain the given field where it matches the given
     * value
     *
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public List<D> getDocumentsByFieldValue(String fieldName, Object fieldValue) {
        return service.getDocumentsByFieldValue(fieldName, fieldValue);

    }

    /**
     * Updates the specified field of a document
     *
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public boolean updateDocumentField(String documentId, String fieldName, Object fieldValue) {
        return service.updateDocumentField(documentId, fieldName, fieldValue);
    }

}
