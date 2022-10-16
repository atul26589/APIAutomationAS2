package com.tmb.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.pojo.Eemployee;
import com.tmb.utils.ApiUtils;
import com.tmb.utils.RandomUtils;

import annotations.FrameworkAnnotations;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reports.ExtentLogger;

import static requestBuilder.RequestBuilder.*;
public class AssignmentTests {

	
	@Test
	@FrameworkAnnotations(author="Atul", category= {"Regression"})
	public void assignmentTest() {
		Response response=buildRequestForGetCalls()
				.get("/employees");
		int size=response.jsonPath().getList("$").size();
	
Eemployee eemployee=Eemployee.builder().setFname(RandomUtils.getFirstName()).setLname(RandomUtils.getLastName()).setId(RandomUtils.getId()).build();
	RequestSpecification requestSpecification=buildRequestForPostCalls().body(eemployee);
	ExtentLogger.logRequest(requestSpecification);
	
	Response postResponse =requestSpecification.post("/employees");
	
	Assertions.assertThat(buildRequestForGetCalls().get("/employees").jsonPath().getList("$").size()).isEqualTo(size+1);
	
	eemployee.setFname("Default name");
	int id=eemployee.getId();
	Response putResponse=buildRequestForPostCalls().pathParam("id", id).body(eemployee).put("/employees/{id}");
	ApiUtils.storeStringAsJsonFile("putResponse.txt", putResponse);
	
	buildRequestForGetCalls().pathParam("id",id).delete("/employees/{id}");
	Assertions.assertThat(buildRequestForGetCalls().get("/employees").jsonPath().getList("$").size()).isEqualTo(size);
	
	}
}
