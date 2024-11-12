package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Rest {

	@GetMapping("/health-check")
	public String getHealthCheck() {
		return "Situation normal all fires up";
	}
}
