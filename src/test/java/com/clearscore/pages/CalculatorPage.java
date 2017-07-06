package com.clearscore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.clearscore.common.SystemProperties;

public class CalculatorPage extends AbstractPage {
	private final static String URL = SystemProperties.CALCULATOR_WEBSITE;

	public CalculatorPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".cs-scalc__range-slider__input")
	private WebElement currentScore;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[2]/input")
	private WebElement goalScore;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[4]/table/tbody/tr[1]/td[2]")
	private WebElement currentRate;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[4]/table/tbody/tr[1]/td[3]")
	private WebElement goalRate;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[4]/table/tbody/tr[2]/td[2]")
	private WebElement currentCost;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[4]/table/tbody/tr[2]/td[3]")
	private WebElement goalCost;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[4]/table/tbody/tr[3]/td[2]")
	private WebElement currentCards;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[4]/table/tbody/tr[3]/td[3]")
	private WebElement goalCards;

	@FindBy(className = "js-total-saving-value")
	private WebElement potentialSavings;

	public CalculatorPage navigateTo() {
		driver.navigate().to(URL);
		return new CalculatorPage(driver);
	}

	public CalculatorPage updateCurrentScore(int number) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("window.scrollBy(0,400)", "");
		for (int i = 1; i <= number; i++) {
			currentScore.sendKeys(Keys.ARROW_LEFT);
		}
		return new CalculatorPage(driver);
	}

	public CalculatorPage updateGoalScore(int number) {
		for (int i = 1; i <= number; i++) {
			goalScore.sendKeys(Keys.ARROW_RIGHT);
		}
		return new CalculatorPage(driver);
	}

	public String getCurrentRate() {
		return currentRate.getText();
	}

	public String getGoalRate() {
		return goalRate.getText();
	}

	public String getCurrentCost() {
		return currentCost.getText();
	}

	public String getGoalCost() {
		return goalCost.getText();
	}

	public String getCurrentCards() {
		return currentCards.getText();
	}

	public String getGoalCards() {
		return goalCards.getText();
	}

	public String getPotentialSavings() {
		return potentialSavings.getText();
	}
}
