package com.example.unittesting.unittesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.example.unittesting.unittesting.data.SomeDataService;


public class SomeBusinessAnnotationsTest {

	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);

	@Before
	public void before() {
		business.setSomeDataService(dataServiceMock);
	}
	
	@Test
	public void calculateSum_Basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		int actualResult = business.calculateSumUsingDatasService();//new int[] {1,2,3}
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_EmptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {  });		
		int actualResult = business.calculateSumUsingDatasService();//calculateSumUsingDatasService
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	
	@Test
	public void calculateSum_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1 });
		int actualResult = business.calculateSumUsingDatasService();//1
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}
	
}
