package com.ryan.rfvhbackend.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(value = "/sessionLogin", method = RequestMethod.POST)
    public void createSessionCookie(@RequestHeader String Authorization) {
        logger.error(Authorization);

    }

}
