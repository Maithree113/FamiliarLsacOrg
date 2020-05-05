package workflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LsacSearchPage {
	
    WebDriver driver; 
    WebDriverWait wait;
     
    public LsacSearchPage(WebDriver driver) { 
        this.driver = driver; 
        wait = new WebDriverWait(driver, 30);
        
    } 
    //Search | The Law School Admission Council
    // Using FindBy for locating elements 
    @FindBy(how = How.XPATH, using = "edit-search") 
    WebElement searchInputBox; 
    
    @FindBy(how = How.ID, using = "edit-submit-sitewide-search") 
    WebElement searchClick; 
    
    @FindBy(how = How.XPATH, using = "//div//article//div//h3/a") 
    WebElement searchResult; 
    
    @FindBy(how = How.XPATH, using = "//[contains(@text,'PrepTest 83')]") 
    WebElement searchResultMobile; 
    
    public String verifyPageTitle()
    {
    	return driver.getTitle();
    }
    
    public boolean verifySearchInputBox()
    {
    	 wait.until(ExpectedConditions.elementToBeClickable(searchInputBox));
    	 return searchInputBox.isDisplayed();
    }
	
    public void clickOnSearch()
    {
    	 wait.until(ExpectedConditions.elementToBeClickable(searchClick));
    	 searchClick.click();
    }
	
    public boolean verifySearchResult(String searchText)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(searchResult));
    	return searchResult.getText().contains(searchText);
    }
    
    public boolean verifySearchResultMobile(String searchText)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(searchResultMobile));
    	return searchResultMobile.getText().contains(searchText);
    }
    
    public void enterSearchValue(String searchText)
    {
    	 wait.until(ExpectedConditions.elementToBeClickable(searchInputBox));
    	 searchInputBox.sendKeys(searchText);
    }

}
