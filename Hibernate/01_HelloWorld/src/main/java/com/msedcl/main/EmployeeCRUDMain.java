package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeCRUDMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee");
			System.out.println("2. Search Employee by Employee Id");
			System.out.println("3. Delete Employee by Employee Id");
			System.out.println("4. Update Employee by Employee Id");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Enter Employee Id:");
				employeeId = scanner.nextInt();
				getEmployeeByEmployeeId(employeeId);
				break;
			case 3:
				System.out.println("Enter Employee Id:");
				employeeId = scanner.nextInt();
				deleteEmployeeByEmployeeId(employeeId);
				break;
			case 4:
				System.out.println("Enter Employee Id:");
				employeeId = scanner.nextInt();
				System.out.println("Enter New Name:");
				name=scanner.next();
				System.out.println("Enter New Salary");
				salary=scanner.nextDouble();
				Employee e1=new Employee(employeeId,name,salary);
				//updateEmployee(e1);
				mergeEmployee(e1);
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

	public static void addNewEmployee(Employee employee) {
		// 1. create entity manager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.create transaction object
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// 3.start transaction
		entityTransaction.begin();

		// 4.save employee object into database
		entityManager.persist(employee);

		// 5.commit transaction
		entityTransaction.commit();

		// 6.close Entity Manager
		entityManager.close();

		System.out.println("Employee created with employee id:" + employee.getEmployeeId());

	}

	public static void getEmployeeByEmployeeId(int employeeId) {
		// 1.create entity manager object

		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from database
		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee != null)
			System.out.println(employee);
		else
			System.out.println("Invalid EmployeeId");

		// 3.close Entitymanager Object
		entityManager.close();
	}

	public static void deleteEmployeeByEmployeeId(int employeeId) {
		// 1.create entity manager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.create transaction object
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// 2.to remove record first get a object of that class and then remove
		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println("Employee deleted with employee id:" + employeeId);

		} else {
			System.out.println("..Invalid Employee Id");
		}
		// 5.commit transaction

		// 6.close Entity Manager
		entityManager.close();

	}



	public static void updateEmployee(Employee employee) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, employee.getEmployeeId());
		if (existingEmployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			existingEmployee.setName(employee.getName());
			existingEmployee.setSalary(employee.getSalary());
			entityTransaction.commit();
			System.out.println("Employee id:" + employee.getEmployeeId() + " is updated succsessfully.");
		} else {
			System.out.println("Invalid id to update..");
		}

		entityManager.close();
	}

	public static void mergeEmployee(Employee employee) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, employee.getEmployeeId());
		if (existingEmployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(employee);

			entityTransaction.commit();
			System.out.println("Employee id:" + employee.getEmployeeId() + " is updated succsessfully.");
		} else {
			System.out.println("Invalid id to update..");
		}

		entityManager.close();

	}

}
