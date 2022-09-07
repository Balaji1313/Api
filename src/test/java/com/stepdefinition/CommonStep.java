package com.stepdefinition;

import org.baseclass1.BaseClass1;
import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass1 {

	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(int int1) {

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		Assert.assertEquals("Verify status code", int1, statusCode);

	}

}
