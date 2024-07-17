package com.springunittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springunittesting.model.Employee;
import com.springunittesting.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@GetMapping("/wishEmp")
	public ResponseEntity<?> wishEmp() {
		return new ResponseEntity<String>(service.wishEmp(), HttpStatus.OK);
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmp(@RequestBody Employee employee){
		 
		boolean status = service.addEmp(employee);
		
		if(status) {
			return ResponseEntity.ok(service.addEmp(employee));
		}else {
			return new ResponseEntity<String>("emp added",HttpStatus.BAD_REQUEST);
		}
	}
}
