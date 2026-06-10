package com.msedcl.main;

import com.msedcl.main.domain.Calculations;

public class CalculationsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculations calculations = null;

		// Addition Using Lambda Expressions

		calculations = (double numberOne, double numberTwo) -> {

			return numberOne + numberTwo;
		};
		double additionResult = calculations.doCalculations(20, 30);
		System.out.println("Addition is::" + additionResult);

		// Subtraction Using Lambda Expressions

		calculations = (double numberOne, double numberTwo) -> {

			return numberOne - numberTwo;
		};
		double subtractionResult = calculations.doCalculations(20, 30);
		System.out.println("Subtraction is::" + subtractionResult);

		// Multiplication Using Lambda Expressions

		calculations = (n1, n2) -> n1*n2;
		double multiplicationResult = calculations.doCalculations(20, 30);
		System.out.println("Subtraction is::" + multiplicationResult);

//Division Using Lambda Expressions

		calculations = (n1, n2)->n1/n2;
		double divisionResult = calculations.doCalculations(30, 30);
		System.out.println("Subtraction is::" + divisionResult);

		
		}
	
	

}
