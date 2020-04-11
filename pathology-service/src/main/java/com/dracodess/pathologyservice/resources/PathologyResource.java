package com.dracodess.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dracodess.pathologyservice.models.Disease;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	List<Disease> diseases = Arrays.asList(
			new Disease("P1", "COVID-19", "Unknown"),
			new Disease("P2", "Malaria", "Malaria Vaccine")
			);
	
	@RequestMapping("/diseases")
	public List<Disease> getDiseases(){			
		
		return diseases;		
	}
	
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {		
		Disease d = diseases.stream()
				.filter(disease -> Id.equals(disease.getId()))
				.findAny()
				.orElse(null);
		return d;
	}

}
