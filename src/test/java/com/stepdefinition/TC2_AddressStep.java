package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.baseclass1.BaseClass1;
import org.junit.Assert;
import org.pojo.AddUserAddress_Input_Pojo;
import org.pojo.AddUserAddress_Output_Pojo;
import org.pojo.DeleteUserAddress_Input_Pojo;
import org.pojo.DeleteUserAddress_Output_Pojo;
import org.pojo.GetUserAddress_Output_Pojo;
import org.pojo.UpdateUserAddress_Input_Pojo;
import org.pojo.UpdateUserAddress_Output_Pojo;

import com.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC2_AddressStep extends BaseClass1 {

	Response response;
	static String AddressId;

	@Given("User add headers and bearer authorization for accessing address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingAddressEndpoints() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	@When("User add request body for Add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForAddNewAddress(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {

		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name,
				mobile, apartment, Integer.valueOf(state), Integer.valueOf(city), Integer.valueOf(country), zipcode,
				address, address_type);
		addBody(addUserAddress_Input_Pojo);

	}

	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String post) {

		response = requestMethodType(post, Endpoints.ADDUSERADDRESS);

	}

	@Then("user verify the addUserAddress response message matches {string}")
	public void userVerifyTheAddUserAddressResponseMessageMatches(String expAddAddress) {

		AddUserAddress_Output_Pojo output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actAddAddress = output_Pojo.getMessage();
		Assert.assertEquals("Verify Address added successfully", expAddAddress, actAddAddress);

		int address_id = output_Pojo.getAddress_id();
		AddressId = String.valueOf(address_id);
	}

	@When("User add request body for update address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForUpdateAddress(String address_id, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		UpdateUserAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(AddressId, first_name,
				last_name, mobile, apartment, Integer.valueOf(state), Integer.valueOf(city), Integer.valueOf(country),
				zipcode, address, address_type);
		addBody(updateAddress_Input_Pojo);
	}

	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String put) {

		response = requestMethodType(put, Endpoints.UPDATEUSERADDRESS);

	}

	@Then("user verify the updateUserAddress response message matches {string}")
	public void userVerifyTheUpdateUserAddressResponseMessageMatches(String expUpdateAdress) {

		UpdateUserAddress_Output_Pojo updateAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);

		String actUpdateAdress = updateAddress_Output_Pojo.getMessage();
		System.out.println("update" + actUpdateAdress);

		Assert.assertEquals("verify update message", expUpdateAdress, actUpdateAdress);

	}

	@When("User add request body for delete existing address")
	public void userAddRequestBodyForDeleteExistingAddress() {

		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(AddressId);
		addBody(deleteUserAddress_Input_Pojo);
	}

	@When("User send {string} request for deleteUserAddress endpoint")
	public void userSendRequestForDeleteUserAddressEndpoint(String delete) {

		response = requestMethodType(delete, Endpoints.DELETEUSERADDRESS);

	}

	@Then("user verify the deleteUserAddress response message matches {string}")
	public void userVerifyTheDeleteUserAddressResponseMessageMatches(String expDeleteAdress) {

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);

		String actDeleteAdress = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address deleted successfullye", expDeleteAdress, actDeleteAdress);

	}

	@Given("User send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String get) {

		response = requestMethodType(get, Endpoints.GETUSERADDRESS);

	}

	@Then("user verify the getUserAddress response message matches {string}")
	public void userVerifyTheGetUserAddressResponseMessageMatches(String expGetAddress) {

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String actGetAddress = getUserAddress_Output_Pojo.getMessage();

		Assert.assertEquals("verify ok message", expGetAddress, actGetAddress);
	}

}
