package com.dracodess.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dracodess.pathologyservice.models.Disease;
import com.dracodess.pathologyservice.models.DiseaseList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {	

	//Hardcoded list of diseases 
		List<Disease> diseases = Arrays.asList(
				new Disease("P1", "COVID-19", "unknown"),
				new Disease("P2", "fever", "advil"),
				new Disease("P3", "cough", "soup")
				);
	
	//Allows Pathology Miscroservice to GET all diseases
	@RequestMapping("/diseases")
	public DiseaseList getDiseases(){
		DiseaseList diseaseList = new DiseaseList();
		diseaseList.setDiseases(diseases);
		
		return diseaseList;		
	}
	
	//Allows Pathology microservice to GET a disease by its ID
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {		
		Disease d = diseases.stream()
				.filter(disease -> Id.equals(disease.getId()))
				.findAny()
				.orElse(null);
		return d;
	}
}
