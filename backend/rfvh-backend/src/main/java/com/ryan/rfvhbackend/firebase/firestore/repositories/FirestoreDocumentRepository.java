package com.ryan.rfvhbackend.firebase.firestore.repositories;

import java.util.Optional;

import com.ryan.rfvhbackend.firebase.firestore.documents.FirestoreDocument;

import org.springframework.data.repository.CrudRepository;

public abstract class FirestoreDocumentRepository<T extends FirestoreDocument> implements CrudRepository<T, String> {

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(T entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<T> findAllById(Iterable<String> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<T> findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends T> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

}
