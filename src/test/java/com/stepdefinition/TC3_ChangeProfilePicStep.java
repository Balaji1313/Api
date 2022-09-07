package com.stepdefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.baseclass1.BaseClass1;
import org.junit.Assert;
import org.pojo.ChangeProfilePic_Output_Pojo;

import com.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_ChangeProfilePicStep extends BaseClass1 {

	Response response;

	@Given("User add headers and bearer authorization for accessing upload profile picture endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingUploadProfilePictureEndpoints() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");

		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);
		addHeaders(headers);

	}

	@When("User add form data for adding profile picture")
	public void userAddFormDataForAddingProfilePicture() throws FileNotFoundException, IOException {
		formData("profile_picture", new File(System.getProperty("user.dir") + getPropertyFileValue("profilepic")));

	}

	@When("User send {string} request for change profile pic endpoint")
	public void userSendRequestForChangeProfilePicEndpoint(String post) {
		response = requestMethodType(post, Endpoints.CHANGEPROFILEPICTURE);

	}

	@Then("user verify the change profile picture response message matches {string}")
	public void userVerifyTheChangeProfilePictureResponseMessageMatches(String expprofilePic) {

		ChangeProfilePic_Output_Pojo Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);

		String actprofilePic = Output_Pojo.getMessage();

		Assert.assertEquals("Verify profile picture updated", expprofilePic, actprofilePic);

	}

}
