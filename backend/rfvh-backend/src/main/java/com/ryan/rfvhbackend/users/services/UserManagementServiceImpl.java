package com.ryan.rfvhbackend.users.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.ryan.rfvhbackend.users.UserPermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final FirebaseAuth firebaseAuth;

    @Autowired
    public UserManagementServiceImpl(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void setUserClaims(String uid, List<UserPermissions> requestedPermissions) throws FirebaseAuthException {
        List<String> permissions = requestedPermissions
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList());

        Map<String, Object> claims = Map.of("custom_claims", permissions);

        firebaseAuth.setCustomUserClaims(uid, claims);

    }

}
