package com.dracodess.admissionsservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dracodess.admissionsservice.models.Patient;

//Controller files handle requests coming from the client

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {
	
	List<Patient> patients = Arrays.asList(
			new Patient("P1", "Henry", "Liberian"),
			new Patient("P2", "Donavan", "Jamaican"),
			new Patient("P3", "Tolu", "Nigerian")
			);
	
	@RequestMapping("/patients")
	public List<Patient> getPatients(){
		
		
		return patients;
	}
	
	@RequestMapping("patients/{Id}") //using curly braces because the Id to request a patient will always be changing
	public Patient getPatientById(@PathVariable("Id") String Id) {
		
		Patient p = patients.stream()
				.filter(patient -> Id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		return p;
	}

}
