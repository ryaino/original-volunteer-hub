package com.ryan.rfvhbackend.firebase.firestore.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;
import com.ryan.rfvhbackend.firebase.firestore.repositories.UserDocumentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import utils.UserDocumentTestUtils;

/**
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDocumentServiceTest {

    private UserDocumentService userDocumentService;
    private UserDocumentTestUtils utils;
    private UserDocument userDocument;
    private List<UserDocument> documents;

    @Mock
    private UserDocumentRepository userDocumentRepository;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);

        userDocumentService = new UserDocumentService(userDocumentRepository);
        utils = new UserDocumentTestUtils();
        userDocument = utils.getDocument();
        documents = utils.getList();

        when(userDocumentRepository.findById(Mockito.anyString())).thenReturn(Optional.of(userDocument));
        when(userDocumentRepository.findAllByFieldValue("name", "Ryan")).thenReturn(documents);
        when(userDocumentRepository.updateDocumentField("111", "name", "Not Ryan")).thenReturn(true);
    }

    @Test
    void testGetDocumentById() {
        UserDocument result = userDocumentService.getDocumentById("111");
        assertEquals(result, userDocument);
    }

    @Test
    void testGetDocumentsByFieldValue() {
        List<UserDocument> result = userDocumentService.getDocumentsByFieldValue("name", "Ryan");
        assertEquals(2, result.size());
    }

    @Test
    void testUpdateDocumentField() {
        boolean result = userDocumentService.updateDocumentField("111", "name", "Not Ryan");
        assertEquals(true, result);
    }
}
