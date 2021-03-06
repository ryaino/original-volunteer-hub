package com.ryan.rfvhbackend.config;

import com.ryan.rfvhbackend.auth.CookieInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Sets up interceptors to be used on requests. {@link CookieInterceptor} is the
 * only one used for now.
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(
        // new
        // CookieInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/sessionLogin",
        // "/api/sessionLogout", "/api/authenticate");
    }

}
