package com.ryan.rfvhbackend.firebase.firestore.controllers;

import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.AbstractFirestoreDocumentRepository;
import com.ryan.rfvhbackend.firebase.firestore.services.AbstractDocumentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Parent controller that holds the logic for crud operations on documents
 */
@RestController
@RequestMapping("/api/document")
public abstract class AbstractDocumentController {

    private AbstractDocumentService<?, ?> service;

    public AbstractDocumentController(AbstractDocumentService<?, ?> service) {
        this.service = service;
    }

    public ResponseEntity<? extends AbstractFirestoreDocument> getDocumentById(String id) {
        AbstractFirestoreDocument document = service.getDocumentById(id);
        return ResponseEntity.ok(document);
    }

}
