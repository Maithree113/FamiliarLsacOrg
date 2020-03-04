package workflow;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class CalculatorWorkflowPage {
	
	    WebDriver driver; 
	    WebDriverWait wait;
	    static WebElement canvas;
	    
	    public CalculatorWorkflowPage(WebDriver driver) { 
	        this.driver = driver; 
	        wait = new WebDriverWait(driver, 30);
	        
	    } 
	    
	    // Using FindBy for locating elements 
	    @FindBy(how = How.ID, using = "fullframe") 
	    WebElement frameId; 
	  
	    @FindBy(how = How.ID, using = "canvas") 
	    WebElement canvasId; 
	    
	  
	    // This method is to set username in username text box
	    public void switchToFrame() 
	    { 
	    	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
	    } 
	    
	    public void clickOnCanvas()
	    {
	    	 canvas = wait.until(ExpectedConditions.elementToBeClickable(canvasId));
	    	 canvas.click();
	    }
	    
	    public void clickOn3OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(0,90).click().build().perform();	 
	    }
	    
	    public void clickOnMinus()
	    {
	    	 new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*2,(255/6)*3).click().build().perform();
	    }
	    
	    public void clickOnEquals()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(150,200).click().build().perform();	 
	    }
	    
	    public void clickOn1OnCanvas()
	    {
	    	  new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*4,(255/6)*3).click().build().perform();
	    }
	    
	    public void clickOn2OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-69,132).click().build().perform();	 
	    }
	    
	    public void clickOn4OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-150,50).click().build().perform();	 
	    }
	    
	    public void clickOn5OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-79,50).click().build().perform();	 
        }
	    
	    public void clickOn6OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(10,50).click().build().perform();	 
	    }
	    
	    public void clickOn7OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-150,-10).click().build().perform();
	    }
	    
	    public void clickOn8OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-79,-10).click().build().perform();	 
	    }
	    
	    public void clickOn9OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(20,-10).click().build().perform();	 
	    }
	    
	    public void clickOn0OnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-150,200).click().build().perform();	 
		}
	    
	    public void clickOndotOnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-79,200).click().build().perform();	 
	    }
	    
	    public void clickOnClearOnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(150,-100).click().build().perform();	 
		}
	    
	    public void clickOnDivisionOnCanvas()
	    {
	    	new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(50,-10).click().build().perform();	 
		}
	    
	    public void processNumber(String number)
	    {
	    	String[] digits = number.split("(?<=.)");
	    	
	    	for(String n : digits)
	    	{
	    		if(n.contains("1"))
	    		{
	    			clickOn1OnCanvas();	    			  
	    		}
	    		else if(n.equals("2"))
	    		{
	    			clickOn2OnCanvas();
	    		}
	    		else if(n.equals("3"))
	    		{
	    			clickOn3OnCanvas();
	    		}
	    		else if(n.equals("4"))
	    		{
	    			clickOn4OnCanvas();
	    		}
	    		else if(n.equals("5"))
	    		{
	    			clickOn5OnCanvas();
	    		}
	    		else if(n.equals("6"))
	    		{
	    			clickOn6OnCanvas();
	    		}
	    		else if(n.equals("7"))
	    		{
	    			clickOn7OnCanvas();
	    		}
	    		else if(n.equals("8"))
	    		{
	    			clickOn8OnCanvas();
	    		}
	    		else if(n.equals("9"))
	    		{
	    			clickOn9OnCanvas();
	    		}
	    		else if(n.equals("0"))
	    		{
	    			clickOn0OnCanvas();
	    		}
	    		else if(n.equals("."))
	    		{
	    			clickOndotOnCanvas();
	    		}
	    		else if(n.equals("-"))
	    		{
	    			clickOnMinus();
	    		}
	    		else
	    		{
	    			System.out.println("Not a valid Number");
	    		}
	    	}
	    }
	    
	    public void performOperation(String ops)
	    {
	    	if(ops.equals("minus"))
			{
		       clickOnMinus();
			}
			else if(ops.equals("division"))
			{
				clickOnDivisionOnCanvas();
			}
			else if(ops.equals("clear"))
			{
				clickOnClearOnCanvas();
			}
			else
			{
				System.out.println("Not a valid operation");
			}		
	    }
	    public void screenInteraction(String imageName)
	    {
	    	 Screen sc = new Screen();
	    	//set a timeout for waiting for the image
	    	 sc.setAutoWaitTimeout(30000); //default is 10 seconds
	    	//wait for an image to get displayed on the screen and then click on it
	    	 try {
	    		 String image =System.getProperty("user.dir")+"/src/test/java/resources/imageMatch/"+"latest.PNG";
				
	    	     //wait for an image with exact match
	    	     //Match match = sc.wait(new Pattern(image).similar((float) 0.9));
	    	     Match matchResult = sc.exists(image);
	    	 System.out.println(matchResult.getScore());
	    	 }
	    	 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	
	    }
	    
	    public boolean screenCompare(String imageName)
	    {
	    	
	      boolean imageIsPresent = false;
	      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    try {
	    	
	    	String compImage =System.getProperty("user.dir")+"/src/test/java/resources/imageMatch/"+imageName;
			
       String imgPath = System.getProperty("user.dir")+"/src/test/java/resources/actualImage/"+"screenshot.png";
	   
	  FileUtils.copyFile(scrFile, new File(imgPath));
	   Finder f = new Finder(imgPath);
	   //System.out.println("abc");
	   f.find(compImage);

	   while(f.hasNext()){

	    System.out.println("found");
	    Match m= f.next();
	    imageIsPresent=true;
	    f.destroy();
	   }

	     }    
	      catch (IOException e)
	   {
	       e.printStackTrace();
	     }
		return imageIsPresent;
	    }
}

