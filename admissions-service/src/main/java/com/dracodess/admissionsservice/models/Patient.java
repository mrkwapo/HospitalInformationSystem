package com.dracodess.admissionsservice.models;

//Patient class handles patient data concerns
public class Patient {
	private String Id;
	private String name;
	private String age;
	
	public Patient() {
		
	}
	public Patient(String id, String name, String age) {
		Id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	

}
