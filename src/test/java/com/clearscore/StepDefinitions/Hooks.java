package com.clearscore.StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	private static final Logger LOG = Logger.getLogger(Hooks.class.getName());

	WebDriver driver;

	// Before will execute before the first step of each
	// scenario. I have ignored @loginError as we do not
	// need the web browser for the API test
	@Before("~@loginError")
	public void startUp() throws IOException {

		// Driver Factory
		try {
			LOG.info("Launching chrome browser");
			System.setProperty("webdriver.chrome.driver",
					new File("./src/test/resources/drivers/chromedriver.exe").getCanonicalPath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			LOG.info("Unable to locate the driver...");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	// It will execute after each scenario
	@After("~@loginError")
	public void tearDown() {
		driver.quit();
	}
}
