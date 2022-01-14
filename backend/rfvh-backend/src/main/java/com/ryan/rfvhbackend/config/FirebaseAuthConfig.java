package com.ryan.rfvhbackend.config;

import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * Sets up the firebase connection for the app
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
@Configuration
public class FirebaseAuthConfig {

    @Value("classpath:serviceAccountKey.json")
    private Resource serviceAccount;

    @Bean
    FirebaseAuth firebaseAuth() throws IOException {
        var options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            var firebaseApp = FirebaseApp.initializeApp(options);
            return FirebaseAuth.getInstance(firebaseApp);
        }

        return FirebaseAuth.getInstance();

    }

}
