package com.webbee.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	@NotNull
	@Size(min=4,message="Name should have atleast 4 characters")
	private String name;
	@NotNull
	@NotBlank
	@Email
	private String email;
	@NotNull
	@Pattern(regexp="\\d{10}",message="Mobile number should be exact 10 digits.")
	@Size(min=10,max=10,message="Mobile number should be exact 10 digits.")
	private String mobile;
	@NotNull
	private long salary;
	@NotNull
	@NotBlank
	private String department;
	
	public Employee() {}

	public Employee(long empId, String name, String email, String mobile, long salary, String department) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
		this.department = department;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", salary="
				+ salary + ", department=" + department + "]";
	}
	
	
	
}
