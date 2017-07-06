package com.clearscore.StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.clearscore.helper.Score;
import com.clearscore.pages.CalculatorPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorStepDefinitions {
	private Hooks hooks;
	WebDriver driver;
	CalculatorPage page;

	public CalculatorStepDefinitions(Hooks hooks) {
		this.hooks = hooks;
	}

	@Given("^a user is on the calculator page$")
	public void aUserIsOnTheCalculatorPage() throws Throwable {
		driver = hooks.getDriver();
		CalculatorPage page = new CalculatorPage(driver);
		page.navigateTo();
	}

	@Given("^the user updates the current score to (\\d+)$")
	public void theUserUpdatesTheCurrentScoreTo(int number) throws Throwable {
		CalculatorPage page = new CalculatorPage(driver);
		page.updateCurrentScore(330);
	}

	@When("^he selects the score goal to be (\\d+)$")
	public void heSelectsTheScoreGoalToBe(int arg1) throws Throwable {
		CalculatorPage page = new CalculatorPage(driver);
		page.updateGoalScore(230);
	}

	@Then("^his current score should be:$")
	public void hisCurrentScoreShouldBe(List<Score> score) throws Throwable {
		CalculatorPage page = new CalculatorPage(driver);
		Score currentScore = score.get(0);
		assertEquals(currentScore.getInterest_rate(), page.getCurrentRate());
		assertEquals(currentScore.getCosts(), page.getCurrentCost());
		assertEquals(currentScore.getCardsAvailable(), page.getCurrentCards());
	}

	@Then("^his score goal should be$")
	public void hisScoreGoalShouldBe(List<Score> score) throws Throwable {
		CalculatorPage page = new CalculatorPage(driver);
		Score goalScore = score.get(0);
		assertEquals(goalScore.getInterest_rate(), page.getGoalRate());
		assertEquals(goalScore.getCosts(), page.getGoalCost());
		assertEquals(goalScore.getCardsAvailable(), page.getGoalCards());
	}

	@Then("^the user potential savings are (\\d+) GBP$")
	public void theUserSPotentialSavingsAreGBP(String number) throws Throwable {
		CalculatorPage page = new CalculatorPage(driver);
		assertEquals(number, page.getPotentialSavings());
	}

}