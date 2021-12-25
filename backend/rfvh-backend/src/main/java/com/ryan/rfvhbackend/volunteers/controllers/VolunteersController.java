package com.ryan.rfvhbackend.volunteers.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ryan.rfvhbackend.firebase.firestore.services.FirebaseVolunteerService;
import com.ryan.rfvhbackend.volunteers.Volunteer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VolunteersController {

  private final FirebaseVolunteerService firebaseVolunteerService;

  @Autowired
  public VolunteersController(FirebaseVolunteerService firebaseVolunteerService) {
    this.firebaseVolunteerService = firebaseVolunteerService;
  }

  @GetMapping("/volunteers")
  public List<Volunteer> getUsers() {
    return firebaseVolunteerService.findAll();
  }

  @PostMapping("/volunteers")
  void addUser(@RequestBody Volunteer volunteer) throws InterruptedException, ExecutionException {
    firebaseVolunteerService.addVolunteer(volunteer);
  }

}
