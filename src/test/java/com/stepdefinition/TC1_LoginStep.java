package com.stepdefinition;

import org.baseclass1.BaseClass1;
import org.junit.Assert;
import org.pojo.Login_Output_Pojo;

import com.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_LoginStep extends BaseClass1 {

	static RequestSpecification reqSpec;
	Response response;
	static String logtoken;

	@Given("User add header")
	public void userAddHeader() {

		addHeader("accept", "application/json");

	}

	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() {

		basicAuth("balaji16293@gmail.com", "Bala@123");

	}

	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String post) {

		response = requestMethodType(post, Endpoints.POSTMANBASICAUTHLOGIN);

	}

	@Then("user verify the login response body firstName present as {string} and get the log token saved")
	public void userVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogTokenSaved(String expName) {

		Login_Output_Pojo output_Pojo = response.as(Login_Output_Pojo.class);
		String actName = output_Pojo.getData().getFirst_name();
		Assert.assertEquals("verify first name field", expName, actName);
		logtoken = output_Pojo.getData().getLogtoken();

	}

}
