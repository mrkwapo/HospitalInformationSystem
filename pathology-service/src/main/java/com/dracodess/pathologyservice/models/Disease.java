package com.dracodess.pathologyservice.models;

public class Disease {

	private String Id;
	private String name;
	
	public Disease(){
		
	}

	public Disease(String id, String name) {
		Id = id;
		this.name = name;
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
	
	

}
