package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class DoctorClient {

    // Define the base URL for the Doctor API
    private static final String BASE_URL = "http://localhost:8080/api/doctors";

    // Create a RestTemplate instance
    private final RestTemplate restTemplate;

    public DoctorClient() {
        this.restTemplate = new RestTemplate();
    }

    // POST method to create a new doctor
    public void createDoctor(Doctor doctor) {
        HttpEntity<Doctor> request = new HttpEntity<>(doctor);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, request, String.class);
        System.out.println("Response: " + response.getBody());
    }

    // GET method to retrieve all doctors
    public void getAllDoctors() {
        ResponseEntity<List> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, List.class);
        List doctors = response.getBody();
        System.out.println("Doctors: " + doctors);
    }

    // Main method to test the client functionality
    public static void main(String[] args) {
        DoctorClient doctorClient = new DoctorClient();

        // Create a new doctor to test the POST request
        Doctor newDoctor = new Doctor(1, "Dr. John Doe", "Cardiologist");
        doctorClient.createDoctor(newDoctor);

        // Retrieve the list of all doctors to test the GET request
        doctorClient.getAllDoctors();
    }
}
