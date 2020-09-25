package com.webbee.assignment.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbee.assignment.entity.Employee;
import com.webbee.assignment.exception.ResourceNotFoundException;
import com.webbee.assignment.repository.EmployeeRepository;
import com.webbee.assignment.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRespository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRespository.findAll();
	}

	@Override
	public Employee getEmployee(Long empId) throws ResourceNotFoundException {
		Employee employee = employeeRespository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id : " + empId));
		return employee;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRespository.delete(employee);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRespository.save(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getNextId() {
		Query query = entityManager.createNativeQuery("SELECT LAST_INSERT_ID() FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'employee_database' AND TABLE_NAME = 'employees'");
		List<java.math.BigInteger> list =query.getResultList();
		Long value  = list.get(0).longValue();
		return value;

	}
}
