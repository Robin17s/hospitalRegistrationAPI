package model;

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
	
	public Visitor() {
		this.timeStamp = localDateTime.now().toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return String.format("%s %s: visited %s%d on %s", firstName, lastName, doctorId == -1 ? "patient" : "doctor ", doctorId, timeStamp);
	}
}