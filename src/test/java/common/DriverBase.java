package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverBase {
	
	enum browserType
	{   
		chrome ,
		IE,
		firefox
	}
	
	/** Sets and returns driver object based on browser value set in envronmentDetail.properties file **/
	
	 public WebDriver createDriver(String browser,WebDriver driver)
	    {
		
	    	switch(browserType.valueOf(browser))
	    	{
	    	  case chrome : System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/driver/chromedriver.exe");
	    		            driver = new ChromeDriver();
	    		            break;
	    	  case IE : System.setProperty("webdriver.IE.driver",System.getProperty("user.dir")+"/src/test/java/driver/IEDriverServer.exe");
    		           driver = new InternetExplorerDriver();
	    		       break;
	    	  case firefox :System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/java/driver/geckodriver.exe");
	    	              DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    	              capabilities.setCapability("marionette",true);
	    	              driver= new FirefoxDriver(capabilities);
	    		          break;
	    	  default :
	    		driver = null;
	    	}
	    	
	    	return driver;
	    }
}
