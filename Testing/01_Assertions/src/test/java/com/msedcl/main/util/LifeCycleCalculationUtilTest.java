package com.msedcl.main.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.beans.BeanProperty;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LifeCycleCalculationUtilTest {
	private CalculationUtil calculationUtil;
	
	@BeforeAll
	static void initialize()
	{
		System.out.println("BEFORE-ALL :: Initialize resources like DB Connections,Object creation");
	}
	
	@BeforeEach
	void setup()
	{
		System.out.println("Before Each:: Create fesh Object before testing functionality");
		calculationUtil=new CalculationUtil();
	}
	
	@Test
	void testAssertEquals()
	{
		System.out.println("Running test 1:: AssertEquals");
		assertEquals(11, calculationUtil.addtion(6, 5));
	}
	
	@Test
	void testAssertNotEqual()
	{
		System.out.println("Running test 2:: AssertNotEquals");
		assertNotEquals(6, calculationUtil.subtraction(10,5));
	}
	
	@AfterEach
	void tearDown()
	{
		System.out.println("After Each:: Clean Up after each test operation");
		calculationUtil=null;
	}
	
	@AfterAll
	static void tearDownAll()
	{
		System.out.println("After ALL:: Release All resources");
	}

}
