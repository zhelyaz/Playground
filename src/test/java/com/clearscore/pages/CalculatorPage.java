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

	@FindBy(css = "input.js-range-current")
	private WebElement currentScoreSlide;

	@FindBy(css = "input.js-range-goal")
	private WebElement goalScoreSlide;

	@FindBy(css = ".js-current-average-rate")
	private WebElement currentAvgRate;

	@FindBy(css = ".js-goal-average-rate")
	private WebElement goalAvgRate;

	@FindBy(css = ".js-current-annual-cost")
	private WebElement currentAnnCost;

	@FindBy(css = ".js-goal-annual-cost")
	private WebElement goalAnnCost;

	@FindBy(css = ".js-current-cc-available")
	private WebElement currentCards;

	@FindBy(css = ".js-goal-cc-available")
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
			currentScoreSlide.sendKeys(Keys.ARROW_LEFT);
		}
		return new CalculatorPage(driver);
	}

	public CalculatorPage updateGoalScore(int number) {
		for (int i = 1; i <= number; i++) {
			goalScoreSlide.sendKeys(Keys.ARROW_RIGHT);
		}
		return new CalculatorPage(driver);
	}

	public String getCurrentRate() {
		return currentAvgRate.getText();
	}

	public String getGoalRate() {
		return goalAvgRate.getText();
	}

	public String getCurrentCost() {
		return currentAnnCost.getText();
	}

	public String getGoalCost() {
		return goalAnnCost.getText();
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
