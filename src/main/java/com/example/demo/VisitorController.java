package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class VisitorController {

	@Autowired
	VisitorRepository rep;
	
	@GetMapping("/health-check")
	public String getHealthCheck() {
		return "Situation normal all fires up";
	}
	
	@PostMapping("/api/visits")
	public String createNewVisitor(@RequestBody Visitor visitor) {
		rep.add(visitor);
		return String.format("Registration of visitor %d complete", visitor.getId());
	}
	
//	method for testing
//	@PostMapping("/api/visits2")
//	public void createNewVisitor2(@RequestBody Visitor visitor) {
//		visitor.setTimeStamp("2024-11-15T09:45:45.890856+01:00[Europe/Brussels]");
//		rep.add(visitor);
//	}
	
	@GetMapping("/api/visits")
	public List<Visitor> getVisitsOfSpecificDate(@RequestParam(name= "date", required= false) String date, @RequestParam(name= "startDate", required= false) String startDate, @RequestParam(name= "endDate", required= false) String endDate) {
		if(startDate != null && endDate != null) {
			return getVisitsBetween2SpecificDates(startDate, endDate);
		}
		
		if(date != null) {
			return rep.getList().stream().filter(value -> value.getTimeStamp().contains(date)).collect(Collectors.toList());			
		}
		
		return Collections.emptyList();
	}
	
//	method for testing
//	@GetMapping("/api/visits2")
//	public List<Visitor> GetVisitsOfSpecificDate2(String date) {
//		return rep.getList();
//	}
	
	public List<Visitor> getVisitsBetween2SpecificDates(String startDate, String endDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start = LocalDate.parse(startDate, formatter);
		LocalDate end = LocalDate.parse(endDate, formatter);
		
		return rep.getList().stream().filter(value -> {
			LocalDate visitorTime = LocalDate.parse(value.getTimeStamp().substring(0, 10), formatter);
			return !visitorTime.isBefore(start) && !visitorTime.isAfter(end);
		}).toList();
	}
}
