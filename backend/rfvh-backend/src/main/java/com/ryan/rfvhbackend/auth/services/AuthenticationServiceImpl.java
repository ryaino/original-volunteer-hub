package com.ryan.rfvhbackend.auth.services;

import javax.servlet.http.Cookie;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public boolean isUserAuthenticated(Cookie cookie) {
        String sessionCookie = cookie.getValue();
        try {
            final boolean checkRevoked = true;
            FirebaseAuth.getInstance().verifySessionCookie(sessionCookie, checkRevoked);
            return true;
        } catch (FirebaseAuthException e) {
            return false;
        }
    }

}
