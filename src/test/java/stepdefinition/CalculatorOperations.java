package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import workflow.CalculatorWorkflowPage;

public class CalculatorOperations {
	
	  static CalculatorWorkflowPage calculatorPage;
		
	  static WebDriver driver;
		
	  public CalculatorOperations()
	  {
			driver = TestBase.getDriver();
	   }
	
	@Given("^i have a online calculator app$")
	public void i_have_a_online_calculator_app() throws Throwable 
	{
		calculatorPage =  PageFactory.initElements(driver, CalculatorWorkflowPage.class); 
		calculatorPage.switchToFrame();
		calculatorPage.clickOnCanvas();	  
	   
	}

	@Given("^first  number is \"([^\"]*)\"$")
	public void first_number_is(String num1) throws Throwable 
	{
		calculatorPage.processNumber(num1);
	}

	@When("^i click on \"([^\"]*)\"$")
	public void i_click_on(String operation) throws Throwable 
	{
		calculatorPage.performOperation(operation);
	}

	@When("^second number is \"([^\"]*)\"$")
	public void second_number_is(String num2) throws Throwable 
	{
		calculatorPage.processNumber(num2);
	}
	
	@Then("^result is as per expected \"([^\"]*)\"$")
	public void result_is_as_per_expected(String imageName) throws Throwable 
	{
		calculatorPage.clickOnEquals();  
		Assert.assertTrue(calculatorPage.screenCompare(imageName));
	}

	@Then("^everything should get cleared \"([^\"]*)\"$")
	public void everything_should_get_cleared(String imageName) throws Throwable 
	{
		calculatorPage.clickOnClearOnCanvas();  
		Assert.assertTrue(calculatorPage.screenCompare(imageName));
	}

}
