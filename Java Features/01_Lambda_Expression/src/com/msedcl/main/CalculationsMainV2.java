package com.msedcl.main;

import com.msedcl.main.domain.Calculations;

public class CalculationsMainV2 {

	public static void main(String[] args) {

		// passing implementation of abstract method as parameter using lambda
		printResult((n1, n2) -> n1 * n2);
		printResult2((x, y) -> x / y, 50, 10);

	}

	public static void printResult(Calculations calculations) {
		Double result = calculations.doCalculations(20, 30);
		System.out.println("Result is::" + result);

	}

	public static void printResult2(Calculations calculations, double n1, double n2) {
		System.out.println("Result of " + n1 + " And " + n2 + "is " + calculations.doCalculations(n1, n2));
	}
}
