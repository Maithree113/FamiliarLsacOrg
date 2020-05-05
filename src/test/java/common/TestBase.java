package common;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;

public class TestBase extends DriverBase {
	

    public static WebDriver driver = null; 
    public static EnvironmentProperties envProp = new EnvironmentProperties();
  
    @Before 
    public void initialize() throws IOException 
    { 
      
         String browser = envProp.getPropValues("browser");
         driver = createDriver(browser);    
         // To open BBlog site 
         driver.get(envProp.getPropValues("url")); 
         // To maximize browser 
         //driver.manage().window().maximize();      
    }
  
    /** This method is the close the browser after operation is performed **/
    
    @After
    // Test cleanup 
    public void TeardownTest() { 
    	if(driver!=null)
    	{
    		driver.quit();
    	}     
    }
    
    /** This method is used to set test report configuration **/
    @AfterClass
    public static void writeExtentReport() throws IOException 
    {
		Reporter.loadXMLConfig(new File(getReportConfigPath()));
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.141.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_211");
	}
    
    /** This method set the path to extent-config.xml file **/
    
    public static String getReportConfigPath() throws IOException
    {
    	String reportConfigPath = envProp.getPropValues(System.getProperty("user.dir")+"reportConfigPath");
    	if(reportConfigPath!= null) 
    		return reportConfigPath;
    	else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
    }
    
    public static WebDriver getDriver()
    {
    	return driver;
    }
    
    public static EnvironmentProperties getEnvironmentProperties()
    {
    	return envProp;
    }
   

}
