package com.example.demo;

import java.time.ZonedDateTime;

public class Visitor {

	private String firstName;
	private String lastName;
	private String doctorId;
	private String timeStamp;
	private ZonedDateTime localDateTime;
	
	public Visitor(String firstName, String lastName, String doctorId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.doctorId = doctorId;
		this.timeStamp = localDateTime.now().toString();
	}

	public String getName() {
		return firstName;
	}

	public void setName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDoctor() {
		return doctorId;
	}

	public void setDoctor(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDateTime() {
		return timeStamp;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s: visited %s%s on %s", firstName, lastName, doctorId.isBlank() ? "patient" : "doctor ", doctorId, timeStamp);
	}
}