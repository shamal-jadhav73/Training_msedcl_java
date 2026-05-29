package com.msedcl.main;

import com.msedcl.main.entity.Address;
import com.msedcl.main.entity.User;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToOneMain {

	public static void main(String[] args) {
		// select();
		// insert();
		// update();
		// merge();
		// remove();
		//detach();
		refresh();
	}

	
	
	public static void refresh()
	{
		//object loaded in java from database
		//object may be updated externally from DB
		
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		User existingUser = entityManager.find(User.class, 4);
		System.out.println(existingUser);
		existingUser.setName("Rajat");
		existingUser.getAddress().setCity("Baroda");
		System.out.println("After changes");
		System.out.println(existingUser);
		
		System.out.println("Refresh Called");
		entityManager.refresh(existingUser);
		System.out.println("After Refresh");
		System.out.println(existingUser);
		;
		
		entityTransaction.commit();
		entityManager.close();
		
		
	}
	public static void detach() {
		// detach= Remove entity from persistence context
		// which means hibernate will stop tracking object changes

		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		User existingUser = entityManager.find(User.class, 4);
		System.out.println("Before Detach");
		System.out.println(existingUser);
         
		entityManager.detach(existingUser);
		
		existingUser.setName("Rahul Dravid");
		existingUser.getAddress().setCity("Navi Mumbai");
		
		entityTransaction.commit();
		entityManager.close();
		
		System.out.println("After changes into Detached object");
		System.out.println(existingUser);
		System.out.println("Check Table");
		

	}

	public static void select() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		User user = entityManager.find(User.class, 1);
		System.out.println(user.getName() + " " + user.getAddress().getCity());
		entityManager.close();
	}

	public static void insert() {

		Address address = new Address(0, "Navi Mumbai", "412312");
		User user = new User(0, "Rahul", address);

		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		transaction.commit();
		entityManager.close();

	}

	public static void update() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, 2);
		if (user != null) {
			transaction.begin();
			user.setAddress(new Address(0, "Dhule", "424002"));
			user.setName("Tina");
			entityManager.merge(user);
			transaction.commit();
			entityManager.close();
		}
	}

	public static void merge() {
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// fetching object from database
		User existingUser = entityManager.find(User.class, 1);
		System.out.println("Object Fetched");
		System.out.println(existingUser);
		entityManager.close();
		System.out.println("Entity Manager Closed.");

		// At this point my existing user in detached state
		existingUser.setName("Seema Rao");
		System.out.println("Modified detached object.");
		System.out.println(existingUser);
		System.out.println("Check your table.");

		entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(existingUser);
		entityTransaction.commit();
		entityManager.close();

	}

	public static void remove() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		User existingUser = entityManager.find(User.class, 6);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(existingUser);
		entityTransaction.commit();
		entityManager.close();
	}
}
