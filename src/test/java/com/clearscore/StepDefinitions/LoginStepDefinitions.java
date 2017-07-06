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
	private final static String LOGIN_ENDPOINT = SystemProperties.LOGIN_ENDPOINT;
	UserLoginRequest loginReq;
	Response response;

	@When("^a user tries to login with \"([^\"]*)\"$")
	public void aUserTriesToLoginWith(String credentials) throws Throwable {
		if (credentials.equalsIgnoreCase("valid")) {
			UserLoginRequest loginReq = new UserLoginRequest();
			loginReq.setDevice("desktop");
			loginReq.setEmail("irzhelyazkov@gmail.com");
			loginReq.setPassword("Mementomori10");
			response = given().contentType(ContentType.JSON).body(loginReq).post(LOGIN_ENDPOINT);
		}
		if (credentials.equalsIgnoreCase("invalid")) {
			UserLoginRequest loginReq = new UserLoginRequest();
			loginReq.setDevice("desktop");
			loginReq.setEmail("dasdasdasd@gmail.com");
			loginReq.setPassword("wrongPass1");
			response = given().contentType(ContentType.JSON).body(loginReq).post(LOGIN_ENDPOINT);
		}
	}

	@Then("^the error status code should be \"([^\"]*)\"$")
	public void theErrorStatusCodeShouldBe(String code) throws Throwable {
		if (code.equalsIgnoreCase("403")) {
			assertEquals(403, response.getStatusCode());
		}
		if (code.equalsIgnoreCase("200")) {
			assertEquals(200, response.getStatusCode());
		}
	}
}
