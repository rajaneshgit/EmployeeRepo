package com.webbee.assignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbee.assignment.entity.Employee;
import com.webbee.assignment.exception.ResourceNotFoundException;
import com.webbee.assignment.service.EmployeeService;

@RestController @CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping(value="/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("empId") Long empId) throws ResourceNotFoundException {
		Employee emp = employeeService.getEmployee(empId);
		return emp;
	}
	
	@PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@PutMapping(value = "/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@Valid @PathVariable(value="empId") Long empId, @RequestBody Employee employee) throws ResourceNotFoundException {
		System.out.println("put calling...");
		Employee emp = employeeService.getEmployee(empId);
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setDepartment(employee.getDepartment());
		emp.setMobile(employee.getMobile());
		emp.setSalary(employee.getSalary());
		Employee updatedEmployee = employeeService.saveEmployee(emp);
		return updatedEmployee;
	}
	
	@DeleteMapping("/{empId}")  //nextId
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="empId") Long empId) throws ResourceNotFoundException{
		Employee employee = employeeService.getEmployee(empId);
		employeeService.deleteEmployee(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
		
	}
	@GetMapping(value="/nextId")
	public Long getNextId()  {
		Long value = employeeService.getNextId();
		return value+1;
	}
}
