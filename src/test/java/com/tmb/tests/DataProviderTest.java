package com.tmb.tests;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	/*@Test(dataProvider="getData")
	public void dpTest() {
		System.out.println("username");
		//Assertions.assertThat(true).isEqualTo(false);
	}*/
	
	@Test(dataProvider="getData1")
	public void dpTest(Map<String,String> data) {
		System.out.println(data.get("username"));
		System.out.println(data.get("password"));
		//Assertions.assertThat(true).isEqualTo(false);
	}
	
	@DataProvider
	public Object[][] getData(){
		//first dim basically number of Times you want to execute
		//second dim indicates number of parameters to the method
		return new Object[][] {
			{"abcd"},
			{"efgh"},
			{"ijkl"}
		};
		
	}
	@DataProvider
	public Object[][] getData1(){
		//first dim basically number of Times you want to execute
		//second dim indicates number of parameters to the method
		Object[][] data= new Object[3][1];
		Map<String,String> map1=new HashMap<>();
		map1.put("username", "sdfgh");
		map1.put("password", "djjfd");
		map1.put("email", "sdfghhjk");
		
		Map<String,String> map2=new HashMap<>();
		map2.put("username", "sdfj9gh");
		map2.put("password", "djkjjfd");
		map2.put("email", "sdfg1hhjk");
		
		Map<String,String> map3=new HashMap<>();
		map3.put("username", "sdfj9jh9gh");
		map3.put("password", "djkcnikc99jjfd");
		map3.put("email", "sdfcjkscjhkg1hhjk");
		
		data[0][0]=map1;
		data[1][0]=map2;
		data[2][0]=map3;
		
		return data;
		
	}
}
