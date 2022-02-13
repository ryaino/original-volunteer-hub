package com.ryan.rfvhbackend.auth.services;

import javax.servlet.http.Cookie;

public interface AuthenticationService {

    boolean isUserAuthenticated(Cookie cookie);

}
