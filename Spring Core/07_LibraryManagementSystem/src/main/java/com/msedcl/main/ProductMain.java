package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.msedcl.main.entity.Product;

import com.msedcl.main.service.ProductService;

import com.msedcl.main.service.ProductServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.msedcl.main");
		
		ProductService productService=applicationContext.getBean(ProductServiceImpl.class);
		Scanner scanner = new Scanner(System.in);
		int productId, choice;
		String name, continueChoice;
		double price;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Product");
			System.out.println("2. Search Product by name");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			
			
			case 2:
				System.out.println("Enter Name:");
				name = scanner.next();
				List<Product> productList2 = productService.getProductByName(name);
				productList2.forEach(e -> System.out.println(e));
				break;

			case 1:
				System.out.println("Enter New Product Name");
				name = scanner.next();
				System.out.println("Enter Price");
				price = scanner.nextDouble();
				Product product = new Product(0, name, price);
				if (productService.addNewProduct(product)!= null) {
					System.out.println("New Product added successfully");
					System.out.println("ProductId :: " + product.getProductId());
				}
				break;
			
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

		applicationContext.close();
		scanner.close();
	}

	}


