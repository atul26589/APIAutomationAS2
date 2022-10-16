package com.tmb.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import annotations.FrameworkAnnotations;
import io.restassured.response.Response;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentReport;
import requestBuilder.RequestBuilder;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;

public class GetTests extends BaseTest{
	
	
	@Test
	@FrameworkAnnotations(author= {"Atul","Sachin"},category = {"Smoke","Get Call"})
	public void getEmployeeDetails() {
		
		//ExtentManager.getTest().assignAuthor("Atul").assignCategory("Smoke");
		Response response=RequestBuilder
				.buildRequestForGetCalls()
		       .get("/employees");
		response.prettyPrint();
		
		ExtentLogger.logResponse(response.asPrettyString());

//ExtentLogger.pass("test started");
		assertThat(response.getStatusCode())
		.isEqualTo(200);
		
		assertThat(response.jsonPath().getList("$").size())
		.isPositive()
		.as("validating size of employee array").isLessThan(260);
	
	
	}

	
	@Test(dataProvider="getData")
	@FrameworkAnnotations(author= {"Atul"},category = {"Regression","Get Call"})
	public void getEmployeeDetail(Integer id, String lastname) {
		Response response=RequestBuilder
				.buildRequestForGetCalls()
		       .pathParam("id",id)
		       .get("/employees/{id}");
		response.prettyPrint();
		
		ExtentLogger.logResponse(response.asPrettyString());
		
		assertThat(response.getStatusCode())
		.isEqualTo(200);
		
		
		assertThat(response.jsonPath().getString("last_name"))
		.as("Comparing the last_name node in the response").isEqualTo(lastname).hasSizeBetween(3, 50);
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
			{1,"Eschweiler"},
			{2,"Palmer"},
			{3,"Smith"},
		};
	}
}
