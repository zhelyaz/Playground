package com.clearscore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.clearscore.common.SystemProperties;

public class LandingPage extends AbstractPage {
	private final static String URL = SystemProperties.LOGIN_WEBSITE;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "accept-cookies")
	private WebElement acceptCookiesButton;

	@FindBy(css = ".cs-cookie.show p")
	private WebElement cookiesNotificationText;

	public void clickAcceptCookies() {
		waitForElementToBeClickable(acceptCookiesButton);
		acceptCookiesButton.click();
	}

	public LandingPage navigateTo() {
		driver.navigate().to(URL);
		return new LandingPage(driver);
	}

	public String getCookiePolicyText() {
		return cookiesNotificationText.getText();
	}

	public boolean verifyCookieBannerNotPresent() {
		return elementNotEnabledAndVisible(cookiesNotificationText);
	}

	public String getCookieValue(String cookieName) {
		return driver.manage().getCookieNamed(cookieName).getValue();
	}
}
