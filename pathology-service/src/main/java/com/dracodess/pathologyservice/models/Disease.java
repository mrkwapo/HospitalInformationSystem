package com.dracodess.pathologyservice.models;

public class Disease {

	private String Id;
	private String description;
	private String treatment;
	
	public Disease(){
		
	}

	public Disease(String id, String name, String treatment) {
		Id = id;
		this.description = name;
		this.treatment = treatment;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	

}
