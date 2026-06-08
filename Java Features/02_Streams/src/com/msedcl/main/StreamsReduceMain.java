package com.msedcl.main;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class StreamsReduceMain {

	
	 public static void main(String[] args) {
		
	
	int[] numbers= {1,2,3,4,5,6,8};
	
	//Print sum of all numbers of arrays
	
	int result=Arrays.stream(numbers).reduce(new IntBinaryOperator() {
		
		@Override
		public int applyAsInt(int left, int right) {
			System.out.println("Left-"+left+":: right= "+right);
			return left+right;
		}
	}).getAsInt();
	
	System.out.println("Sum::"+result);
	System.out.println("-".repeat(80));
	System.out.println("Using Shortest form of lambda");
	System.out.println("-".repeat(80));
	System.out.println(Arrays.stream(numbers).reduce((l,r)->l+r).getAsInt());
	
	 }
}
