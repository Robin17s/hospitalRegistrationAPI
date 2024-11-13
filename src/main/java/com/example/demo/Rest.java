package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Rest {
	
	VisitorRepository rep = new VisitorRepository();
	
	@GetMapping("/health-check")
	public String getHealthCheck() {
		return "Situation normal all fires up";
	}
	
	@PostMapping("/api/visits")
	public void createNewVisitor(@RequestBody Visitor visitor) {
		rep.add(visitor);
	}
}
