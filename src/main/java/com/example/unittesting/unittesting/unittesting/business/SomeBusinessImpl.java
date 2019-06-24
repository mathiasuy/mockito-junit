package com.example.unittesting.unittesting.unittesting.business;

import com.example.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService sameDataService;
	
	public void setSomeDataService(SomeDataService someDataService1) {
		this.sameDataService = someDataService1;
	}
	
	
	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
	
	public int calculateSumUsingDatasService() {
		int sum = 0;
		int[] data = sameDataService.retrieveAllData();
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
	
}
