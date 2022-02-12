package com.ryan.rfvhbackend.auth;

import javax.servlet.http.Cookie;

public interface AuthenticationService {

    boolean isUserAuthenticated(Cookie cookie);

}
