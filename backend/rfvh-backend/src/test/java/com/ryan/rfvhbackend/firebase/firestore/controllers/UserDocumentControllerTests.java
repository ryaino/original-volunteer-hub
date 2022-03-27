package com.ryan.rfvhbackend.firebase.firestore.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.services.UserDocumentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import utils.UserDocumentTestUtils;

/**
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public class UserDocumentControllerTests {

    private UserDocumentController userDocumentController;

    @Mock
    private UserDocumentService userDocumentService;

    private UserDocument userDocument;
    private UserDocumentTestUtils utils;
    private List<UserDocument> documents;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);
        userDocumentController = new UserDocumentController(userDocumentService);
        utils = new UserDocumentTestUtils();
        userDocument = utils.getDocument();
        documents = utils.getList();

        when(userDocumentService.getDocumentById("111")).thenReturn(userDocument);
        when(userDocumentService.getDocumentsByFieldValue("name", "Ryan")).thenReturn(documents);
        when(userDocumentService.updateDocumentField("111", "name", "Not Ryan")).thenReturn(true);
    }

    @Test
    void testGetUserById() {
        ResponseEntity<UserDocument> response = userDocumentController.getUserById("111");
        assertEquals(response.getBody(), userDocument);
    }

    @Test
    void testGetUsersByFieldValue() {
        ResponseEntity<List<UserDocument>> response = userDocumentController.getUsersByFieldValue("name", "Ryan");
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testUpdateFieldForUser() {
        ResponseEntity<Boolean> response = userDocumentController.updateFieldForUser("111", "name", "Not Ryan");
        assertEquals(true, response.getBody());

    }
}
