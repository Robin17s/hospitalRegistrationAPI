package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
//	@PostMapping("/api/visits2")
//	public void createNewVisitor2(@RequestBody Visitor visitor) {
//		visitor.setTimeStamp("2024-11-15T09:45:45.890856+01:00[Europe/Brussels]");
//		rep.add(visitor);
//	}
	
	@GetMapping("/api/visits")
	public List<Visitor> GetVisitsOfSpecificDate(@RequestParam(name= "date") String date) {
		return rep.getList().stream().filter(value -> value.getTimeStamp().contains(date)).collect(Collectors.toList());
	}
	
//	@GetMapping("/api/visits2")
//	public List<Visitor> GetVisitsOfSpecificDate2(String date) {
//		return rep.getList();
//	}
}
