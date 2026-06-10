package com.msedcl.main.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

 class CalculationUtilTest {

	@Test
	void testAssertEquals()
	{
		CalculationUtil calculationUtil= new CalculationUtil();
		assertEquals(10, calculationUtil.addtion(5, 5));
	}
	
	
	@Test
	void testAssertNotEqual()
	{
		CalculationUtil calculationUtil= new CalculationUtil();
		assertNotEquals(6, calculationUtil.subtraction(10, 5));
	}
	
	@Test
	void testAssertTrue()
	{
		CalculationUtil calculationUtil= new CalculationUtil();
		assertTrue(calculationUtil.isPositive(9));
	}
	
	@Test
	void testAssertFalse()
	{
		CalculationUtil calculationUtil= new CalculationUtil();
		assertFalse(calculationUtil.isPositive(-9));
	}
	
	@Test
	void testAssertNull()
	{
		CalculationUtil calculationUtil= new CalculationUtil();
		assertNull(calculationUtil.getNullValue());
	}
	
	
	@Test
	void testAssertNotNull()
	{
		CalculationUtil calculationUtil= new CalculationUtil();
		assertNotNull(calculationUtil.getName());
	}
	
	@Test
	void testassertAll()
	{
		CalculationUtil calculationUtil= new CalculationUtil();
		assertAll(()->assertEquals(6, calculationUtil.addtion(1,5)),
				()->assertNotEquals(5, calculationUtil.subtraction(5, 2)),
				()->assertTrue(calculationUtil.isPositive(9)),
				()->assertFalse(calculationUtil.isPositive(-9)),
				()->assertNull(calculationUtil.getNullValue()),
				()->assertNotNull(calculationUtil.getName()));
	}
}
