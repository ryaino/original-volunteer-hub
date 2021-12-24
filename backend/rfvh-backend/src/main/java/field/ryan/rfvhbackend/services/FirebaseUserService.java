package field.ryan.rfvhbackend.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import field.ryan.rfvhbackend.repositories.User;

public interface FirebaseUserService {

    void addUser(User user) throws InterruptedException, ExecutionException;

    List<User> findAll();
}
