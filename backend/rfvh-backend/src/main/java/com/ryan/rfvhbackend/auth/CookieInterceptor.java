package com.ryan.rfvhbackend.auth;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Checks every request for a valid cookie. This saves having to add the check
 * in the code for each request.
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public class CookieInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(CookieInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            logger.debug("found {} cookies in request", cookies.length);
            for (Cookie cookie : cookies) {
                if (StringUtils.equalsIgnoreCase(cookie.getName(), "session")) {
                    logger.debug("session cookie present");
                    try {
                        final boolean checkRevoked = true;
                        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifySessionCookie(cookie.getValue(),
                                checkRevoked);
                        FirebaseAuth.getInstance().revokeRefreshTokens(decodedToken.getUid());

                        // Traverse cookie s Return true if login status is found to continue executing
                        // method originally requested url to controller
                        return true;
                    } catch (FirebaseAuthException e) {
                        logger.error("Session cookie is unavailable, invalid or revoked. Error: {}", e.toString());
                        response.sendRedirect("/login");
                    }
                }
            }
        }
        logger.error("Interceptor is intercepting request");
        return true;

    }

}
