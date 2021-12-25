package com.ryan.rfvhbackend.volunteers.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ryan.rfvhbackend.firebase.firestore.services.FirebaseVolunteerService;
import com.ryan.rfvhbackend.volunteers.Volunteer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example controller for reading and writing volunteers
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VolunteersController {

  Logger logger = LoggerFactory.getLogger(VolunteersController.class);

  private final FirebaseVolunteerService firebaseVolunteerService;

  @Autowired
  public VolunteersController(FirebaseVolunteerService firebaseVolunteerService) {
    this.firebaseVolunteerService = firebaseVolunteerService;
  }

  /**
   * Fetch all volunteers
   *
   * @return
   */
  @GetMapping("/volunteers")
  public List<Volunteer> getVolunteers() {
    logger.info("Fetching all volunteers");
    return firebaseVolunteerService.findAll();
  }

  /**
   * Add a new volunteer
   *
   * @param volunteer
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @PostMapping("/volunteers")
  void addVolunteer(@RequestBody Volunteer volunteer) throws InterruptedException, ExecutionException {
    logger.info("Creating new volunteer with values: {}", volunteer.toString());
    firebaseVolunteerService.addVolunteer(volunteer);
  }

}
