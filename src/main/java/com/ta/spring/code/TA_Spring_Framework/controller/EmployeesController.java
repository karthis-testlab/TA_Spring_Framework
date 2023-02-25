package com.ta.spring.code.TA_Spring_Framework.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ta.spring.code.TA_Spring_Framework.pojo.files.Employees;
import com.ta.spring.code.TA_Spring_Framework.service.EmployeesService;


@RestController
public class EmployeesController {
	
	@Autowired
	EmployeesService empService;	
	
	@RequestMapping(path = "/api/employees", method=RequestMethod.GET)
	public List<Employees> getEmployees() {		
		return empService.getAllEmployees();
	}
	
	
	@GetMapping(path = "/api/employee/{id}")
	public Employees getEmployee(@PathVariable int id) {		
		return empService.getEmployee(id);
	}
	
	@PostMapping(path = "/api/add/employee", consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee) {
		Employees newEmployee = empService.addEmployee(employee);	
		if(newEmployee == null) {
			return ResponseEntity.internalServerError().body(newEmployee);
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(newEmployee.getEmpId())
				  .toUri();
		return ResponseEntity.created(uri).build();
	}	

}