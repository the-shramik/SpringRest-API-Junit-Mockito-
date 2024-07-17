package com.springunittesting.service.impl;

import com.springunittesting.model.Employee;
import com.springunittesting.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService{

	@Override
	public String wishEmp() {
		
		return "Good morning gyz..! Have a nice day..!";
	}

	@Override
	public boolean addEmp(Employee employee) {
		
		return true;
	}

}
