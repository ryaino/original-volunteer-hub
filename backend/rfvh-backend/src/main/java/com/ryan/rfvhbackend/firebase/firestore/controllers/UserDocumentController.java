package com.ryan.rfvhbackend.firebase.firestore.controllers;

import java.util.List;

import com.ryan.rfvhbackend.firebase.firestore.documents.AbstractFirestoreDocument;
import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.services.UserDocumentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests that are related to the users collection
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@RestController
public class UserDocumentController extends AbstractDocumentController<UserDocument> {

    Logger logger = LoggerFactory.getLogger(UserDocumentController.class);

    @Autowired
    public UserDocumentController(UserDocumentService userDocumentService) {
        super(userDocumentService);

    }

    @GetMapping("/user")
    public ResponseEntity<UserDocument> getUserById(@RequestParam String id) {
        return getDocumentById(id);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDocument>> getUsersByFieldValue(@RequestParam String fieldName,
            @RequestParam Object fieldValue) {
        return ResponseEntity.ok(getDocumentsByFieldValue(fieldName, fieldValue));
    }
}
