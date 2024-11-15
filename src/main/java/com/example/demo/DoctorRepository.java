package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DoctorRepository {

	private List<Doctor> list;
	
	public DoctorRepository() {
		this.list = new ArrayList<>();
	}
	
	public void add(Doctor doctor) {
		list.add(doctor);
	}

	public List<Doctor> getList() {
		return list;
	}
	
	public void remove(Doctor doctor) {
		list.remove(doctor);
	}
}
