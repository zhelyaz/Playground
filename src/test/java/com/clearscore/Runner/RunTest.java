package com.clearscore.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
/*
 * The runner class does not need to have any code in it.
 * Here we put annotations to specify that the
 * cucumber features would be run through it and
 * you can specify feature files to be picked up plus
 * the steps package location.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		snippets = SnippetType.CAMELCASE,
		glue = "com.clearscore.StepDefinitions",
		plugin = {
				"pretty",
				"html:target/cucumber",
		}

		)
public class RunTest {
}
