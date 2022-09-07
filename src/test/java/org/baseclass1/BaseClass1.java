package org.baseclass1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass1 {
	RequestSpecification reqSpec;
	public static Response response;

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"C:\\Users\\MITHRA\\eclipse-workspace\\OMRBranchAPIAutomation\\config\\config.properties"));
		String value = (String) properties.get(key);
		return value;

	}

	public void formData(String key, File file) {
		reqSpec = reqSpec.multiPart(key, file);

	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public Response requestMethodType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endPoint);

			break;
		case "PUT":
			response = reqSpec.log().all().put(endPoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endPoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endPoint);
			break;
		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}

	public String getAsString(Response response) {
		String asString = response.asString();
		return asString;

	}

	public String getAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	public void basicAuth(String username, String password) {
		reqSpec.auth().preemptive().basic(username, password);
	}

}
