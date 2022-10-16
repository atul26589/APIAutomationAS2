package com.tmb.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tmb.constants.FrameworkConstants;
import com.tmb.constants.FrameworkConstantswithSingleton;
import com.tmb.pojo.*;
import com.tmb.utils.ApiUtils;
import com.tmb.utils.RandomUtils;

import annotations.FrameworkAnnotations;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentReport;
import requestBuilder.RequestBuilder;

import static io.restassured.RestAssured.*;

import java.lang.reflect.Method;

import static com.tmb.utils.RandomUtils.*;
public class PostTests extends BaseTest{
	
	@Test
	@FrameworkAnnotations(author= {"Atul"},category = {"Regression","Post Call"})
	public void postCallTest() {
		//create an employee in the db using post call
		//construct using pojo and lombok builder
	Eemployee employee=	Eemployee
		.builder()
		.setFname(getFirstName())
		.setLname(getLastName())
		.setId(getId())
		.build();
		
	Response response=	RequestBuilder
			.buildRequestForPostCalls()
				.body(employee)
		.post("/employees");
		
	response.prettyPrint();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
		
		
		ExtentLogger.logResponse(response.asPrettyString());
		
	}
	@Test
	@FrameworkAnnotations(author= {"Atul"},category = {"Regression","Post Call"})
	public void postRequestUsingExternalFile(Method method) {
		String resource=ApiUtils.readJsonAndGetAsString(FrameworkConstants.getGetRequestJSONFolderpath()+"request.json")
	                     .replace("fname", RandomUtils.getFirstName())
	                     .replace("id",String.valueOf(RandomUtils.getId()));
		
		Response response=	RequestBuilder
				.buildRequestForPostCalls()
					.body(resource)
			.post("/employees");
			
		response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
		
		ApiUtils.storeStringAsJsonFile(FrameworkConstants.getGetResponseJSONFolderpath()+method.getName()+"response.json",response);
			Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	
	
	}

	
	
	@Test
	@FrameworkAnnotations(author= {"Atul"},category = {"Regression","Post Call"})
	public void postRequestUsingExternalFile1(Method method) {
		String resource=ApiUtils.readJsonAndGetAsString(FrameworkConstantswithSingleton.getInstance().getGetRequestJSONFolderpath()+"request.json")
	                     .replace("fname", RandomUtils.getFirstName())
	                     .replace("id",String.valueOf(RandomUtils.getId()));
		
		
		//Interface
		
		RequestSpecification requestspecification=RequestBuilder
				.buildRequestForPostCalls()
				.body(resource);
		
		
		requestspecification.post("/employees");
		ExtentLogger.logRequest(requestspecification);
		//response.prettyPrint();
		Response response=	requestspecification
			.post("/employees");
		
			
		response.prettyPrint();
		
		ApiUtils.storeStringAsJsonFile(FrameworkConstants.getGetResponseJSONFolderpath()+method.getName()+"response.json",response);
			Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	
			ExtentLogger.logResponse(response.asPrettyString());	}
}
