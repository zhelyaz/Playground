package com.clearscore.StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.clearscore.api.UserLoginRequest;
import com.clearscore.common.SystemProperties;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginStepDefinitions {

	/**
	 * Internal Logger.
	 */
	private final static String login = SystemProperties.LOGIN_ENDPOINT;
	UserLoginRequest loginReq;
	// RestAssured imported framework
	Response response;

	@When("^a user tries to login with \"([^\"]*)\"$")
	public void aUserTriesToLoginWith(String credentials) throws Throwable {
		if (credentials.equalsIgnoreCase("valid")) {
			// hardcoded user
			UserLoginRequest loginReq = new UserLoginRequest();
			loginReq.setDevice("desktop");
			loginReq.setEmail("irzhelyazkov@gmail.com");
			loginReq.setPassword("Mementomori10");

			/*
			 * making API call using the RestAssured template we need to specify
			 * the contentTupe of the application pass the body of the request
			 * and the type of request we are performing.
			 */
			response = given().contentType(ContentType.JSON).body(loginReq).post(login);
		}
		// I have extended the requirement here by adding additional test
		if (credentials.equalsIgnoreCase("invalid")) {
			UserLoginRequest loginReq = new UserLoginRequest();
			loginReq.setDevice("desktop");
			loginReq.setEmail("dasdasdasd@gmail.com");
			loginReq.setPassword("wrongPass1");
			response = given().contentType(ContentType.JSON).body(loginReq).post(login);
		}
	}

	@Then("^the error status code should be \"([^\"]*)\"$")
	public void theErrorStatusCodeShouldBe(String code) throws Throwable {
		if (code.equalsIgnoreCase("403")) {
			/*
			 * getting the status code from the response object and making the
			 * assertion
			 */
			assertEquals(403, response.getStatusCode());
		}
		if (code.equalsIgnoreCase("200")) {
			assertEquals(200, response.getStatusCode());
		}
	}
}
