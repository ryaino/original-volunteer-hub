package com.ryan.rfvhbackend.user.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ryan.rfvhbackend.firebase.firestore.services.FirebaseUserService;
import com.ryan.rfvhbackend.user.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  private final FirebaseUserService firebaseUserService;

  @Autowired
  public UserController(FirebaseUserService firebaseUserService) {
    this.firebaseUserService = firebaseUserService;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return firebaseUserService.findAll();
  }

  @PostMapping("/users")
  void addUser(@RequestBody User user) throws InterruptedException, ExecutionException {
    firebaseUserService.addUser(user);
  }

}
