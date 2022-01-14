package com.ryan.rfvhbackend.auth;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.SessionCookieOptions;
import com.google.gson.Gson;

import org.apache.commons.collections4.MultiValuedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles everything when a user logs in and creates a session
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserSignInController {

    Logger logger = LoggerFactory.getLogger(UserSignInController.class);

    @RequestMapping(value = "/api/sessionLogin", method = RequestMethod.POST)
    public ResponseEntity<String> createSessionCookie(@RequestHeader String authorization, HttpServletResponse response)
            throws IOException {

        long expiresIn = TimeUnit.MINUTES.toMillis(30);
        SessionCookieOptions options = SessionCookieOptions.builder().setExpiresIn(expiresIn).build();

        try {
            String sessionCookie = FirebaseAuth.getInstance().createSessionCookie(authorization, options);
            MultiValueMap<String, String> headers = new HttpHeaders();
            // headers.add("session", sessionCookie);

            Cookie cookie = new Cookie("session", sessionCookie);
            response.addCookie(cookie);

            return ResponseEntity.ok(new Gson().toJson("test"));
        } catch (FirebaseAuthException e) {
            logger.error("Unable to create session cookie");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        logger.error(authorization);
        return ResponseEntity.badRequest().body("Cannot Log in");

    }

}
