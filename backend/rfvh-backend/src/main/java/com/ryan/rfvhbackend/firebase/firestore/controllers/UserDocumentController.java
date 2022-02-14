package com.ryan.rfvhbackend.firebase.firestore.controllers;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.services.UserDocumentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests that are related to the users collection
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Controller
public class UserDocumentController {

    Logger logger = LoggerFactory.getLogger(UserDocumentController.class);

    private UserDocumentService userDocumentService;

    public UserDocumentController(UserDocumentService userDocumentService) {
        this.userDocumentService = userDocumentService;

    }

    @GetMapping("/api/document/user")
    public ResponseEntity<UserDocument> getUserDocumentById(@RequestParam String userId) {
        UserDocument document = userDocumentService.getUserDocument(userId);

        return ResponseEntity.ok(document);
    }
}
