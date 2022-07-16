package com.ryan.rfvhbackend.firebase.firestore.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ryan.rfvhbackend.firebase.firestore.documents.UserDocument;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public class UserDocumentRepositoryTest {

    private UserDocumentRepository userDocumentRepository;

    @BeforeEach
    void initialize() {
        userDocumentRepository = new UserDocumentRepository();
    }

    @Test
    void testClassType() {
        Class<?> result = userDocumentRepository.classType();
        assertEquals(UserDocument.class, result);
    }

    @Test
    void testCollectionName() {
        String result = userDocumentRepository.collectionName();
        assertEquals("users", result);
    }

}
