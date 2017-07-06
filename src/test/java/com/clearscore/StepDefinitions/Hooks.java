package com.clearscore.StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	WebDriver driver;

	@Before("~@loginError")
	public void startUp() throws IOException {

		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {
			try {
				System.out.println("Launching chrome browser");
				System.setProperty("webdriver.chrome.driver",
						new File("./src/test/resources/drivers/chromedriver").getCanonicalPath());
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			} catch (Exception e) {
				System.out.println("Unable to locate the driver...");
			}
		} else {
			try {
				System.out.println("Launching chrome browser");
				System.setProperty("webdriver.chrome.driver",
						new File("./src/test/resources/drivers/chromedriver.exe").getCanonicalPath());
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			} catch (Exception e) {
				System.out.println("Unable to locate the driver...");
			}
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	@After("~@loginError")
	public void tearDown() {
		driver.quit();
	}
}
