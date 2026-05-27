package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.entity.LoginDetails;
import com.msedcl.main.util.HibernateUtil;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoginMain {

	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		int userId;
		String password;
		 int invalid_count=0;
		 int max=0;
		

		/*EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2.Get Employee from database
		LoginDetails loginDetails = entityManager.find(LoginDetails.class, 101);

		if (loginDetails != null)
			System.out.println(loginDetails);
		else
			System.out.println("Invalid login Details");
(
		// 3.close Entitymanager Object
		entityManager.close();
		*/
		
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter UserId:");
		    userId =scanner.nextInt();
		 //   System.out.println("Enter Password:");
		  //  password =scanner.next();
		    
		     check_deatails(userId);
		     
		    
		     
			
		}
		
	
		
		

	
	
	
	
	public static void check_deatails(int userId)
	{
		EntityManager entityManager = HibernateUtil.getEntityManager();
		// 2.Get Employee from database
				LoginDetails loginDetails = entityManager.find(LoginDetails.class, userId);
				
				System.out.println(loginDetails);
		if (loginDetails != null) {
			
			
			
			 if(loginDetails.getStatus().equalsIgnoreCase("Active"))
			 {
				 
				 
				
				    Scanner scanner = new Scanner(System.in);
					System.out.println("Enter Password:");
				    String password=scanner.next();
				    
				    if(password.equals(loginDetails.getPassword()))
				    		{
				    	       System.out.println("Welcome");
				    		}
				    else
				    {
				    	
				    	System.out.println("Incorrect Password.");
				    	increment_count(loginDetails);
				    }
			 }
			 
			 else
			 {
				 System.out.println("User is blocked");
			 }
			
		}
		else
			System.out.println("Invalid login Details");

		// 3.close Entitymanager Object
		entityManager.close();
		
	}



	private static void increment_count(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		EntityManager entityManager = HibernateUtil.getEntityManager();
		LoginDetails loginDetails2=entityManager.find(LoginDetails.class, loginDetails.getLoginID());
		if(loginDetails2!=null)
		{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		loginDetails2.setInvalidLoginCount(loginDetails2.getInvalidLoginCount()+1);
		entityTransaction.commit();
		if(loginDetails2.getInvalidLoginCount()==3)
		{
			blockuser(loginDetails2);
		}
		
		entityManager.close();
		}
		
		else
			System.out.println("Invalid Login Id.");
		
	}









	private static void blockuser(LoginDetails loginDetails2) 
	{
		EntityManager entityManager = HibernateUtil.getEntityManager();
		LoginDetails loginDetails=entityManager.find(LoginDetails.class, loginDetails2.getLoginID());
		if(loginDetails2!=null)
		{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		loginDetails.setStatus("Blocked");
		entityTransaction.commit();
		System.out.println("User is blocked..Contact Admin.");
		
		
		}
		
		else
			System.out.println("Invalid Login Id.");
		
		
	}
	}
		
			
