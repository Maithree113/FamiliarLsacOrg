package workflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LsacHomePage {
	
	 WebDriver driver; 
	 WebDriverWait wait;
	     
	 public LsacHomePage(WebDriver driver) 
	 { 
	    this.driver = driver; 
	    wait = new WebDriverWait(driver, 30);
	        
	 } 
	 
	 //The Law School Admission Council | LSAC
	 
	 @FindBy(how = How.XPATH, using = "//a[@href='/search']") 
	 WebElement searchLink; 
	 
	 @FindBy(how = How.XPATH, using = "//[contains(@text,'Open navigation menu')]") 
	 WebElement menuLink; 
	 
	 public String verifyPageTitle()
	 {
	    return driver.getTitle();
	 }
	 
	 public void clickOnMenuLink()
	 {
		 wait.until(ExpectedConditions.elementToBeClickable(menuLink));
		 menuLink.click();	 
	 }
	 
	 public void clickOnSearchMobile()
	 {
		 TouchActions action= new TouchActions(driver);
		 action.moveByOffset(88,1055).click();
	 }
	 
	 public void clickOnSearch()
	 {
	    wait.until(ExpectedConditions.elementToBeClickable(searchLink));
	    searchLink.click();
	 }

	 
	 public boolean searchIsPresent()
	 {
		 boolean isPresent = true;
		 
		 if(searchLink.isDisplayed())
		 {
			 isPresent= true;
		 }
		 else
		 {
			 isPresent=false;
		 }
		 
		 return isPresent;
	 }
	 
	 public boolean menuLinkIsPresent()
	 {
		 boolean isPresent = true;
		 
		 if(menuLink.isDisplayed())
		 {
			 isPresent= true;
		 }
		 else
		 {
			 isPresent=false;
		 }
		 
		 return isPresent;
	 }
}
