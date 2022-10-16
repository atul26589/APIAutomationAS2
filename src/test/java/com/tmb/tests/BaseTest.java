package com.tmb.tests;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import reports.ExtentLogger;
import reports.ExtentReport;

public class BaseTest {
	
	@BeforeSuite
	public void setUpSuite() {
		
	}
	
	@AfterSuite
	public void tearDownSuite() {
		
	}
	
	@BeforeMethod
	public void setUp(Method m) {
		
				
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
	}

}
