package com.msedcl.main.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name = "name",length=50,nullable=false)
	private String name;
	
	@Column(name = "salary",nullable=false)
	private double salary;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="department_id")
	private Department department;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String name, double salary, Department department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", department="
				+ department + "]";
	}
	
	
}
