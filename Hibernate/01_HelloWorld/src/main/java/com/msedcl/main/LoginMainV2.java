package com.msedcl.main;

import java.util.Scanner;

import javax.security.auth.login.FailedLoginException;

import com.msedcl.main.entity.LoginDetails;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoginMainV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter UserId:");
		int userId = scanner.nextInt();
		System.out.println("Enter Password:");
		String password = scanner.next();

		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		LoginDetails logindetails = getuserid(userId, entityManager);

		if (logindetails == null) {
			System.out.println("User Not Found. Invalid User Id.");
		} else if (isBlocked(logindetails)) {

			System.out.println("User id Blocked.Please contact System Administrator");

		} else {
			processLogin(logindetails, password);
		}

		tx.commit();
		entityManager.close();
		scanner.close();

	}

	private static void processLogin(LoginDetails logindetails, String password) {

		if(isPasswordCorrect(logindetails,password))
		{
			successfulLogin(logindetails);
		}
		else
		{
			FailedLogin(logindetails);
		}
	}

	private static void FailedLogin(LoginDetails logindetails) {
		// TODO Auto-generated method stub
		incrementInvalidCount(logindetails);
		System.out.println("Invalid Password");
		if(logindetails.getInvalidLoginCount()>=3)
		{
			blockAccount(logindetails);
		}
		System.out.println("Account blocked after 3 attempts");
	}

	private static void blockAccount(LoginDetails logindetails) {
		// TODO Auto-generated method stub
		logindetails.setStatus("BLOCKED");
	}

	private static void incrementInvalidCount(LoginDetails logindetails) {
		// TODO Auto-generated method stub
		
	}

	private static void successfulLogin(LoginDetails logindetails) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome"+ logindetails.getLoginID());
		resetInvalidCount(logindetails);
	}

	private static void resetInvalidCount(LoginDetails logindetails) {
		// TODO Auto-generated method stub
		logindetails.setInvalidLoginCount(0);
	}

	private static boolean isPasswordCorrect(LoginDetails logindetails, String password) {
		// TODO Auto-generated method stub
		return logindetails.getPassword().equalsIgnoreCase(password);
	}

	private static boolean isBlocked(LoginDetails logindetails) {
		// TODO Auto-generated method stub
		return logindetails.getStatus().equalsIgnoreCase("Blocked");
	}

	private static LoginDetails getuserid(int userId, EntityManager entityManager) {
		// TODO Auto-generated method stub

		return entityManager.find(LoginDetails.class, userId);

	}

}
