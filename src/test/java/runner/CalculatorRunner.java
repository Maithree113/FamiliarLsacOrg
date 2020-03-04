package runner;

/** This is Web Based Scenario Runner **/

import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

  @CucumberOptions(features = { "src/test/java/features/" }, 
					 glue = { "stepdefinition","common"}, 
					 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reportsUI/report.html"},
					 monochrome = true, 
					 tags = {"@UI"})

	@Test
	public class CalculatorRunner extends AbstractTestNGCucumberTests 
	{
	 //cucumber framework will execute this from the above defined @CucumberOptions annotations
	}
