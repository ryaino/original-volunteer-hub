package com.ryan.rfvhbackend.users.services;

import java.util.List;

import com.google.firebase.auth.FirebaseAuthException;
import com.ryan.rfvhbackend.users.UserPermissions;

/**
 * Responsible for managing what permissions a user has
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public interface UserManagementService {

    void setUserClaims(String uid, List<UserPermissions> requestedPermissions) throws FirebaseAuthException;

}
