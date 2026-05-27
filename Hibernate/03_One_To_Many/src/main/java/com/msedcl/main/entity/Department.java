package com.msedcl.main.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="department_details")
public class Department {
@Id
@Column(name="department_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int departmentId;

@Column(name="department_name",length = 80,nullable = false)
private String departmentName;


@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="department_id")
private List<Employee> employees;
public Department() {
	// TODO Auto-generated constructor stub
}
public Department(int departmentId, String departmentName, List<Employee> employees) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.employees = employees;
}
public int getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public List<Employee> getEmployees() {
	return employees;
}
public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}
@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
			+ employees + "]";
}

}


