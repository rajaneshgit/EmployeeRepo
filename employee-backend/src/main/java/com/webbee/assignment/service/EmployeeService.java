package com.webbee.assignment.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.webbee.assignment.entity.Employee;
import com.webbee.assignment.exception.ResourceNotFoundException;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long empId) throws ResourceNotFoundException;

	void deleteEmployee(Employee employee);

	Employee saveEmployee(Employee employee);
	
	Long getNextId();


	
}
