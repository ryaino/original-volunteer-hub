package com.ryan.rfvhbackend.admin.controllers;

import java.util.List;

import com.google.firebase.auth.FirebaseAuthException;
import com.ryan.rfvhbackend.users.UserPermissions;
import com.ryan.rfvhbackend.users.services.UserManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controls calls to admin functions
 */
@RestController
public class AdminController {

    private final UserManagementService userManagementService;

    @Autowired
    public AdminController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/user-claims/{uid}")
    public void setUserClaims(@PathVariable String uid, @RequestBody List<UserPermissions> requestedClaims)
            throws FirebaseAuthException {
        userManagementService.setUserClaims(uid, requestedClaims);
    }

}
