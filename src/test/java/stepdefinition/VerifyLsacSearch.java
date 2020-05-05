package stepdefinition;

import org.openqa.selenium.WebDriver;

import common.EnvironmentProperties;
import common.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import workflow.LsacHomePage;
import workflow.LsacSearchPage;

public class VerifyLsacSearch {
	
	static LsacHomePage homePage;
	static LsacSearchPage searchPage;
	
	static EnvironmentProperties envProp;
	
	static WebDriver driver;
	
	public VerifyLsacSearch()
	{
			driver = TestBase.getDriver();
			envProp = TestBase.getEnvironmentProperties();
	 }

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable 
	{
	   if(envProp.getPropValues("DriverType").contains("Mobile"))
	   {
		   Assert.assertTrue(homePage.menuLinkIsPresent());
	   }
	   else
	   {
	     String pageTitle = homePage.verifyPageTitle();
	     Assert.assertEquals("", pageTitle);
	   }
	}

	@Given("^user can see search on home page$")
	public void user_can_see_search_on_home_page() throws Throwable 
	{
		 if(envProp.getPropValues("DriverType").contains("Mobile"))
		 {
			 homePage.clickOnMenuLink();
		 }
		 else
		 {
	        Assert.assertTrue(homePage.searchIsPresent());
		 }
	}

	@When("^user clicks on search$")
	public void user_clicks_on_search() throws Throwable 
	{
		 if(envProp.getPropValues("DriverType").contains("Mobile"))
		 {	
			 homePage.clickOnSearchMobile();
		 }
		 else
		 {
	         homePage.clickOnSearch();
		 }
	}
    
	@When("^user clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable 
	{
	   searchPage.clickOnSearch();
	}
	
	@Then("^search screen should be presented to user$")
	public void search_screen_should_be_presented_to_user() throws Throwable 
	{
		 if(envProp.getPropValues("DriverType").contains("Mobile"))
		 {	
			 Assert.assertTrue(searchPage.verifySearchInputBox());
		 }
		 else
		 {
			 String pageTitle = searchPage.verifyPageTitle();
			 Assert.assertEquals("", pageTitle);
		 }
		
	}

	@Given("^user is on search screen$")
	public void user_is_on_search_screen() throws Throwable 
	{
		if(envProp.getPropValues("DriverType").contains("Mobile"))
		 {	
			homePage.clickOnMenuLink();
			homePage.clickOnSearchMobile();
			
		 }
		else
		{
		   homePage.clickOnSearch();
		}
		
	    Assert.assertTrue(searchPage.verifySearchInputBox());
	}

	@Given("^user types \"([^\"]*)\"$")
	public void user_type(String searchText) throws Throwable 
	{
	   searchPage.enterSearchValue(searchText);
	}

	@Then("^all results matching \"([^\"]*)\" should be displayed$")
	public void all_results_matching_should_be_displayed(String searchText) throws Throwable 
	{
		if(envProp.getPropValues("DriverType").contains("Mobile"))
		 {	
			Assert.assertTrue(searchPage.verifySearchResultMobile(searchText));
		 }
		else
		{
	        Assert.assertTrue(searchPage.verifySearchResult(searchText));
		}
	}

}
