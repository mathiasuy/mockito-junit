package com.example.unittesting.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.unittesting.unittesting.data.SomeDataService;

//My stub
class SomeDataServiceStub implements SomeDataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

//PRoblemas: A medida que el caso se hace màs complejo, es màs difìcil darle un nombre adecuado para poder identificarlo
//Alternativa: usar javadoc o mock
//Se puede crear las clases que implementen esa interface dinàmicamente y solucionar el problema
class SomeDataServiceOneElementStub implements SomeDataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {1};
	}
}

class SomeDataServiceEmptyStub implements SomeDataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}


public class SomeBusinessStubTest {

	@Test
	public void calculateSum_Basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDatasService();//new int[] {1,2,3}
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_EmptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDatasService();//calculateSumUsingDatasService
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	
	@Test
	public void calculateSum_OneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDatasService();//1
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}
	
}
