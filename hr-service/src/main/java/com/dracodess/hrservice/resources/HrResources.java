package com.dracodess.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dracodess.hrservice.models.Employee;
import com.dracodess.hrservice.models.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResources {
	
	//Hardcoded list of employees
	List<Employee> employees = Arrays.asList(
			new Employee("E1", "Nate", "Kwapo", "Med Tech"),
			new Employee("E2", "Remi", "Swen", "Doctor"),
			new Employee("E3", "Kona", "Boylowlu", "Nurse")
			);
	
	//Allows Hr Microservices to GET all employees
	@RequestMapping("/employees")
	public EmployeesList getEmployees(){
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employees);
		return employeesList;		
	}
	
	//Allows Hr Microservices to GET an employee by Id	
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById(@PathVariable("Id")String Id) {
		Employee e = employees.stream()
				.filter(employee -> Id.equals(employee.getId()))
				.findAny()
				.orElse(null);		
		return e;
	}
}
