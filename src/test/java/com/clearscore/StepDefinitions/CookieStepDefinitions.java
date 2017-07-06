package com.clearscore.StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.clearscore.pages.LandingPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CookieStepDefinitions {

	WebDriver driver;
	LandingPage page;
	private Hooks hooks;

	public CookieStepDefinitions(Hooks hooks) {
		this.hooks = hooks;
	}

	@Given("^clearscore website is loaded$")
	public void clearscoreWebsiteIsLoaded() throws Throwable {
		driver = hooks.getDriver();
		LandingPage page = new LandingPage(driver);
		page.navigateTo();
	}

	@Then("^I should be notified about the cookie usage policy$")
	public void iShouldBeNotifiedAboutTheCookieUsagePolicy() throws Throwable {
		LandingPage page = new LandingPage(driver);
		assertEquals("We use cookies to improve your experience.", page.getCookiePolicyText());
	}

	@When("^a new user acknolwdges the cookie policy$")
	public void aNewUserAcknolwdgesTheCookiePolicy() throws Throwable {
		LandingPage page = new LandingPage(driver);
		page.clickAcceptCookies();
	}

	@Then("^the cookie notification should disappear$")
	public void theCookieNotificationShouldDisappear() throws Throwable {
		LandingPage page = new LandingPage(driver);
		assertTrue(page.verifyCookieBannerNotPresent());
	}

	@Then("^the appropriate cookie should be set$")
	public void theAppropriateCookieShouldBeSet() throws Throwable {
		LandingPage page = new LandingPage(driver);
		assertEquals("true", page.getCookieValue("CS_ACCEPT_COOKIES"));
	}

	@When("^the page is reloaded$")
	public void thePageIsReloaded() throws Throwable {
		driver.navigate().refresh();
	}

	@Then("^the cookie notification should not appear$")
	public void theCookieNotificationShouldNotAppear() throws Throwable {
		LandingPage page = new LandingPage(driver);
		assertTrue(page.verifyCookieBannerNotPresent());
	}

}