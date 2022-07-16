package com.ryan.rfvhbackend.firebase.authentication.controllers;

import com.ryan.rfvhbackend.firebase.authentication.AuthUser;
import com.ryan.rfvhbackend.firebase.authentication.services.UserAuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * All the endpoints for performing CRUD operations on Authentication Users
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Controller
public class UserAuthController {

    Logger logger = LoggerFactory.getLogger(UserAuthController.class);

    private final UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/api/authUser")
    public ResponseEntity<String> createNewUser(@RequestBody AuthUser user) {
        logger.debug("Received request to create new Auth User: {}", user);

        userAuthService.createNewUser(user);
        return ResponseEntity.ok().build();
    }

}
