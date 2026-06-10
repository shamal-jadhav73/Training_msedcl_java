package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private JdbcTemplate jdbcTemplate;

	private static final String ADD_NEW_EMPLOYEE = "INSERT INTO employee_details(name,salary) VALUES(?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details SET name=?,salary=? WHERE employee_id=?";
	private static final String DELETE_EMPLOYEE = "DELETE FROM employee_details WHERE employee_id=?";
	private static final String GET_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT * from employee_details WHERE employee_id=?";
	private static final String GET_ALL_EMPLOYEE = "SELECT * from employee_details";
	private static final String GET_COUNT_OF_EMPLOYEE = "SELECT COUNT(*) from employee_details";

	public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded Constructor called of : EmployeeRepositoryImpl");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub

		int rowsDeleted = jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
		if (rowsDeleted > 0)
			return true;
		else
			return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_EMPLOYEE_ID, (rs,row)->new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)), employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
//		RowMapper<Employee> employeeRowMapper = (rs, row) -> 
//		new Employee(
//				rs.getInt(1), 
//				rs.getString(2), 
//				rs.getDouble(3));
//		
//		
//		return jdbcTemplate.query(SELECT_ALL_EMPLOYEE, employeeRowMapper);
//same code in comment above is expressed in lambda expression below

		
		
		return jdbcTemplate.query(GET_ALL_EMPLOYEE, (rs,row)->new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
	}

	@Override
	public List<Employee> getAllEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_COUNT_OF_EMPLOYEE, Long.class);
	}

	@Override
	public List<Employee> getMaxSalariedEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Employee addNewEmployee(Employee employee) {

		int rowsInserted = jdbcTemplate.update(ADD_NEW_EMPLOYEE, employee.getName(), employee.getSalary());

		if (rowsInserted > 0)
			return employee;
		else
			return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int rowsUpdated = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getName(), employee.getSalary(),
				employee.getEmployeeId());
		if (rowsUpdated > 0)
			return employee;
		else
			return null;
	}

}
