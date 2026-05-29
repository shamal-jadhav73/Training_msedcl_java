package com.msedcl.main;

import java.util.Arrays;
import java.util.List;

import com.msedcl.main.entity.Department;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//select();
		insert();

	}
	
	public static void insert()
	{
		EntityManager entityManager=HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee1=new Employee(0,"Abhay",190000);
		Employee employee2=new Employee(0,"Prasad",180000);
		
		List<Employee> employees=Arrays.asList(employee1,employee2);
		Department department=new Department(0,"sales",employees);
		
		entityManager.persist(department);
		
		entityTransaction.commit();
		entityManager.close();
		
	}
	
	public static void select()
	{
		EntityManager entityManager=HibernateUtil.getEntityManager();
		Department existingDepartment=entityManager.find(Department.class, 1);
		entityManager.close();
		System.out.println(existingDepartment.getDepartmentName());
		
		List<Employee> employees = existingDepartment.getEmployees();
		
		employees.forEach(e->System.out.println(e));
	}

} 
