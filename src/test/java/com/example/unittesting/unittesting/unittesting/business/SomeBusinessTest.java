package com.example.unittesting.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1,2,3});
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_EmptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { });
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	
	@Test
	public void calculateSum_OneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 1 });
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}
	
}
