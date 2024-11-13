package com.example.demo;

import java.time.ZonedDateTime;

public class Visitor {

	private int id;
	private String firstName;
	private String lastName;
	private int doctorId;
	private String timeStamp;
	private ZonedDateTime localDateTime;
	
	public Visitor(int id, String firstName, String lastName, int doctorId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doctorId = doctorId;
		this.timeStamp = localDateTime.now().toString();
	}
	
	public Visitor(int id, String firstName, String lastName) {
		this(id, firstName, lastName, -1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDoctor() {
		return doctorId;
	}

	public void setDoctor(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDateTime() {
		return timeStamp;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s: visited %s%d on %s", firstName, lastName, doctorId == -1 ? "patient" : "doctor ", doctorId, timeStamp);
	}
}