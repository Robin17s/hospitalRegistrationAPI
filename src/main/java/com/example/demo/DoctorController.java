package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DoctorController {

	DoctorRepository docrep = new DoctorRepository();
	
	@PostMapping("/api/doctors")
	public String createNewDoctor(@RequestBody Doctor doctor) {
		docrep.add(doctor);
		return String.format("Registration of doctor %d complete", doctor.getId());
	}
	
	@PutMapping("/api/doctors/{id}")
	public void updateDoctor(@PathVariable int id, @RequestBody DoctorUpdateRequest request) {
		List<Doctor> list = docrep.getList().stream().filter(value -> value.getId() == id).collect(Collectors.toList());
		
		if(list.size() == 1) {
			list.get(0).setName(request.getName());
			list.get(0).setSpecialization(request.getSpecialization());
		}
	}
	
	@DeleteMapping("/api/doctors/{id}")
	public void deleteDoctor(@PathVariable int id) {
		List<Doctor> list = docrep.getList().stream().filter(value -> value.getId() == id).collect(Collectors.toList());
		
		if(list.size() == 1) {
			docrep.remove(list.get(0));
		}
	}
	
	@GetMapping("/api/doctors")
	public List<Doctor> getAllDoctors(){
		return docrep.getList();
	}
	
	@GetMapping("/api/doctors/{id}")
	public Doctor getDoctorOfSpecificId(@PathVariable int id) {
		List<Doctor> list = docrep.getList().stream().filter(value -> value.getId() == id).collect(Collectors.toList());
		
		if(list.size() == 1) {
			return list.get(0);
		}
		
		return null;
	}
}
