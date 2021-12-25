package com.ryan.rfvhbackend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RFVHBackendApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RFVHBackendApplication.class, args);
	}

}
