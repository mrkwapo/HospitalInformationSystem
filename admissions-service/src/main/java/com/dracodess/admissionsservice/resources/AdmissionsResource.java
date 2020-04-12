package com.dracodess.admissionsservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dracodess.admissionsservice.models.DiseaseList;
import com.dracodess.admissionsservice.models.EmployeesList;
import com.dracodess.admissionsservice.models.Patient;

//Controller files handle requests coming from the client

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {
	
	//RestTemplate is used to make an API call from one microservice to another
	//If you use @Autowired annotation on a field, that field will be autowired with bean having matching data type
	//This field is autowired to the Bean in /admissionsservice/AdmissionsServiceMsApplication.java
	@Autowired
	private RestTemplate restTemplate;
	
	//Hard coded list of patients
	List<Patient> patients = Arrays.asList(
			new Patient("P1", "Henry", "39"),
			new Patient("P2", "Donavan", "27"),
			new Patient("P3", "Tolu", "42")
	
			);
	
	//Admissions microservice is the only service with access to GET all patients or one by Id
	@RequestMapping("/patients")
	public List<Patient> getPatients(){		
		return patients;
	}
		
	@RequestMapping("/patients/{Id}") //using curly braces because the Id to request a patient will always be changing
	public Patient getPatientById(@PathVariable("Id") String Id) {
			
		Patient p = patients.stream()
				.filter(patient -> Id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		return p;
	}
	
	//This gives admissions microservice access to HR microservice to GET all physicians 
	@RequestMapping("/physicians")
	public EmployeesList getPhysicians(){
		EmployeesList employeesList = restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
		
		return employeesList;
	}
	
	//This gives admissions microservice access to pathology microservice to GET all diseases
	@RequestMapping("/diseases")
	public DiseaseList getDiseases() {
		DiseaseList diseaseList = restTemplate.getForObject("http://pathology-service/pathology/diseases", DiseaseList.class);
				
		return diseaseList;
	}


}
