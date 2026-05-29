package com.msedcl.main;

import com.msedcl.main.entity.Department;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ManyToOneMain {
	
	public static void main(String[] args) {
		
		//select();
		insert();
		
	}

	
	
	
	public static void select()
	{
		EntityManager entityManager=HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, 1);
		entityManager.close();
		System.out.println(existingEmployee);
	}
	
	public static void insert()
	{
		EntityManager entityManager=HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		Employee employee= new Employee(0,"Seema",190000,new Department(1,"IT"));
		
		entityManager.persist(employee);
		
		entityTransaction.commit();
		entityManager.close();
		
		
	}
}
