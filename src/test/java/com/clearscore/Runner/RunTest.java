package com.clearscore.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

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
