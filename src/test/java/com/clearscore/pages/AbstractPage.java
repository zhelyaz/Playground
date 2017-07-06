package com.clearscore.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected boolean elementNotEnabledAndVisible(WebElement webElement) {
		try {
			if (!(webElement.isDisplayed() && webElement.isEnabled())) {
				return false;
			} else {
				return true;
			}
		} catch (NoSuchElementException ex) {
			return true;
		}
	}

}
